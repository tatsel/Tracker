package by.epamlab.web.controllers;

import by.epamlab.issues.model.Activity;
import by.epamlab.issues.model.Assignment;
import by.epamlab.issues.model.Task;
import by.epamlab.issues.service.ActivityService;
import by.epamlab.issues.service.AssignmentService;
import by.epamlab.issues.service.TaskService;
import by.epamlab.projects.model.Member;
import by.epamlab.projects.model.Project;
import by.epamlab.projects.service.MemberService;
import by.epamlab.projects.service.ProjectService;
import by.epamlab.projects.service.StatusService;
import by.epamlab.users.service.UserService;
import by.epamlab.web.forms.IssueForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
        model.addObject("taskList", taskService.loadTaskList());
        model.setViewName("issues");
        return model;

    }

    @RequestMapping(value = "/home/issues/createIssue", method = RequestMethod.GET)
    public ModelAndView createIssuePage() {

        ModelAndView model = new ModelAndView();
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = user.getUsername();
        List<Project> leadOrManagerProjects = memberService.loadProjectMemberList(userService.findUserByLogin(name));
        model.addObject("noProjects", leadOrManagerProjects.isEmpty());
        System.out.print(leadOrManagerProjects.isEmpty());
        model.addObject("projects", leadOrManagerProjects);
        //model.addObject("employees", userService.loadUserList());
        model.addObject("issueForm", new IssueForm());
        model.setViewName("createIssue");
        return model;

    }

    @RequestMapping(value = "/home/issues/addIssue", method = RequestMethod.POST)
    public ModelAndView addProject(@Validated IssueForm issueForm, BindingResult bindingResult) {

        ModelAndView model = new ModelAndView("redirect:/home/issues/createIssue");

        if (bindingResult.hasErrors()) {
            return createIssuePage();
        }
        Task task = new Task();
        Assignment assignment = new Assignment();
        Activity activity = new Activity();
        task.setProject(projectService.getProjectById(issueForm.getProject()));
        task.setDescription(issueForm.getDescription());
        task.setPsd(java.sql.Date.valueOf(issueForm.getPsd()));
        task.setPed(java.sql.Date.valueOf(issueForm.getPed()));
        task.setStatus(statusService.getStatusByName("Not started"));
        taskService.addTask(task);
        task = taskService.getLastTask();


        assignment.setTask(task);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = user.getUsername();
        Set<Member> members = projectService.getProjectById(issueForm.getProject()).getMembers();
        Member member = new Member();
        for (Member projmember: members) {
            if (projmember.getEmployee().getId() == userService.findUserByLogin(name).getId()) {
                member = projmember;
            }
        }
        assignment.setMember(member);
        assignmentService.addAssignment(assignment);
        assignment = assignmentService.getLastAssignment();


        activity.setDate(new Date(new java.util.Date().getTime()));
        activity.setMember(member);
        activity.setAssignment(assignment);
        activity.setComment("blabla");
        activityService.addActivity(activity);

        return model;

    }
}
