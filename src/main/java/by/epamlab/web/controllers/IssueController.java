package by.epamlab.web.controllers;

import by.epamlab.issues.model.*;
import by.epamlab.issues.service.ActivityService;
import by.epamlab.issues.service.AssignmentService;
import by.epamlab.issues.service.TaskService;
import by.epamlab.projects.model.Member;
import by.epamlab.projects.model.Project;
import by.epamlab.projects.model.Status;
import by.epamlab.projects.service.MemberService;
import by.epamlab.projects.service.ProjectService;
import by.epamlab.projects.service.StatusService;
import by.epamlab.users.model.Employee;
import by.epamlab.users.service.UserService;
import by.epamlab.web.forms.AssigneeForm;
import by.epamlab.web.forms.IssueForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping
public class IssueController {

    @Autowired
    private MemberService memberService;
    @Autowired
    ActivityService activityService;
    @Autowired
    private StatusService statusService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private UserService userService;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private AssignmentService assignmentService;

    @RequestMapping(value = "/home/issues", method = RequestMethod.GET)
    public ModelAndView issuesPage() {
        ModelAndView model = new ModelAndView();
        model.addObject("assignmentsList", assignmentService.loadAssignmentsList());
        model.addObject("title", "Issues - Simple Tracker");
        model.setViewName("issues");
        return model;

    }

    @RequestMapping(value = "/home/issues/my", method = RequestMethod.GET)
    public ModelAndView myIssuesPage() {
        ModelAndView model = new ModelAndView();
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = user.getUsername();
        Employee employee = userService.findUserByLogin(name);
        model.addObject("members", employee.getMembers());
        model.addObject("title", "My Issues - Simple Tracker");
        model.setViewName("myissues");
        return model;

    }

    @RequestMapping(value = "/home/issues/createIssue", method = RequestMethod.GET)
    public ModelAndView createIssuePage() {
        ModelAndView model = new ModelAndView();
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = user.getUsername();
        List<Project> leadOrManagerProjects = memberService.loadProjectMemberList(userService.findUserByLogin(name));
        model.addObject("noProjects", leadOrManagerProjects.isEmpty());
        model.addObject("projects", leadOrManagerProjects);
        model.addObject("issueForm", new IssueForm());
        model.addObject("title", "Create Issue - Simple Tracker");
        model.setViewName("createIssue");
        return model;
    }

    @RequestMapping(value = "/home/issues/changeStatus/{id}/{statusId}", method = RequestMethod.POST)
    public ModelAndView changeStatus(@PathVariable Integer id, @PathVariable Integer statusId) {

        ModelAndView model = new ModelAndView("redirect:/home/issues/issuedetails/"+id);
        Assignment assignment = assignmentService.getAssignmentById(id);
        Task task = assignment.getTask();
        Project project = task.getProject();
        Activity activity = new Activity();
        activity.setDate(new Date(new java.util.Date().getTime()));
        activity.setAssignment(assignment);
        activity.setMember(assignment.getMember());
        Status status = statusService.getStatusById(statusId);
        task.setStatus(status);
        if ("Completed".equals(status.getName())) {
            task.setAed(new Date(new java.util.Date().getTime()));
            activity.setComment(Constants.ACTIVITY_COMPLETE);
        }
        if ("Suspended".equals(status.getName())) {
            activity.setComment(Constants.ACTIVITY_SUSPEND);
        }
        if ("In progress".equals(status.getName())) {
            task.setAed(null);
            if (task.getAsd() == null) {
                task.setAsd(new Date(new java.util.Date().getTime()));
                activity.setComment(Constants.ACTIVITY_START_PROGRESS);
            } else {
                activity.setComment(Constants.ACTIVITY_CONTINUE);
            }
            if ("Not started".equals(project.getStatus().getName())) {
                project.setStatus(status);
                project.setAsd(new Date(new java.util.Date().getTime()));
                projectService.addProject(project);
            }
        }
        activityService.addActivity(activity);
        taskService.addTask(task);
        return model;
    }

    @RequestMapping(value = "/home/issues/addIssue", method = RequestMethod.POST)
    public ModelAndView addIssue(@Validated IssueForm issueForm, BindingResult bindingResult) {

        ModelAndView model = new ModelAndView("redirect:/home/issues/createIssue");

        if (bindingResult.hasErrors()) {
            return createIssuePage();
        }

        Task task = new Task();
        Assignment assignment = new Assignment();
        Activity activity = new Activity();

        task.setProject(projectService.getProjectById(issueForm.getProject()));
        task.setDescription(issueForm.getDescription());
        task.setSummary(issueForm.getSummary());
        task.setPsd(java.sql.Date.valueOf(issueForm.getPsd()));
        task.setPed(java.sql.Date.valueOf(issueForm.getPed()));
        task.setStatus(statusService.getStatusByName("Not started"));
        taskService.addTask(task);

        assignment.setTask(task);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = user.getUsername();
        Set<Member> members = task.getProject().getMembers();
        Member member = new Member();
        for (Member projmember: members) {
            if (projmember.getEmployee().getId() == userService.findUserByLogin(name).getId()) {
                member = projmember;
            }
        }
        assignment.setMember(member);
        assignmentService.addAssignment(assignment);

        activity.setDate(new Date(new java.util.Date().getTime()));
        activity.setMember(member);
        activity.setAssignment(assignment);
        activity.setComment(Constants.ACTIVITY_ADD_TASK);
        activityService.addActivity(activity);

        return model;

    }

    @RequestMapping(value = "/home/issues/issuedetails/{id}", method = RequestMethod.GET)
    public ModelAndView issueDetailsId(@PathVariable Integer id) {

        ModelAndView model = new ModelAndView("issueDetails");
        Assignment assignment = assignmentService.getAssignmentById(id);
        model.addObject("assignment", assignment);
        model.addObject("activities", assignment.getActivities());
        model.addObject("members", assignment.getTask().getProject().getMembers());
        model.addObject("attachments", assignment.getTask().getAttachments());
        model.addObject("assignee", new AssigneeForm());
        model.addObject("attachment", new Attachment());
        model.addObject("title", "Issue Details - Simple Tracker");
        return model;

    }

    @RequestMapping(value = "/home/issues/changeAssignee/{id}", method = RequestMethod.POST)
    public ModelAndView changeAssignee(@PathVariable Integer id, @Validated AssigneeForm assigneeForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return issueDetailsId(id);
        }

        ModelAndView model = new ModelAndView("redirect:/home/issues/issuedetails/"+id);
        Assignment assignment = assignmentService.getAssignmentById(id);
        Member member = memberService.getMemberById(assigneeForm.getMemberId());
        Activity activity = new Activity();
        activity.setDate(new Date(new java.util.Date().getTime()));
        activity.setAssignment(assignment);
        activity.setMember(assignment.getMember());
        activity.setComment(Constants.ACTIVITY_CHANGE_ASSIGNEE);
        assignment.setMember(member);
        assignmentService.addAssignment(assignment);
        activityService.addActivity(activity);
        return model;
    }


    @RequestMapping(value = "/home/issues/issuedetails", method = RequestMethod.GET)
    public ModelAndView issueDetails() {

        ModelAndView model = new ModelAndView("issueDetails");
        model.addObject("title", "Issue Details - Simple Tracker");
        return model;
    }

    @RequestMapping(value = "/home/issues/deleteIssue/{id}", method = RequestMethod.POST)
    public ModelAndView deleteIssue(@PathVariable Integer id) {

        ModelAndView model = new ModelAndView("redirect:/home/issues");
        taskService.deleteTask(id);
        return model;

    }
}
