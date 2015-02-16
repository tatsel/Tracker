package by.epamlab.web.controllers;

import by.epamlab.projects.model.Project;
import by.epamlab.projects.model.Status;
import by.epamlab.projects.service.ProjectService;
import by.epamlab.projects.service.StatusService;
import by.epamlab.users.model.Employee;
import by.epamlab.users.service.UserService;
import by.epamlab.web.forms.ProjectForm;
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

@Controller
@RequestMapping
public class ProjectController {

    @Autowired
    private ProjectService projectService;
    @Autowired
    private StatusService statusService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/home/projects", method = RequestMethod.GET)
    public ModelAndView projectsPage() {

        ModelAndView model = new ModelAndView();
        model.addObject("title", "Projects - Simple Tracker");
        model.addObject("projectsList", projectService.loadProjectList());
        model.setViewName("projects");
        return model;

    }

    @RequestMapping(value = "/home/projects/my", method = RequestMethod.GET)
    public ModelAndView myProjectsPage() {

        ModelAndView model = new ModelAndView();
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = user.getUsername();
        Employee employee = userService.findUserByLogin(name);
        model.addObject("title", "My Projects - Simple Tracker");
        model.addObject("members", employee.getMembers());
        model.setViewName("myprojects");
        return model;

    }

    @RequestMapping(value = "/admin/projects/createProject", method = RequestMethod.GET)
    public ModelAndView createProjectPage() {

        ModelAndView model = new ModelAndView();
        model.addObject("title", "Create Project - Simple Tracker");
        model.addObject("projectForm", new ProjectForm());
        model.setViewName("createProject");
        return model;

    }

    @RequestMapping(value = "/admin/projects/addProject", method = RequestMethod.POST)
    public ModelAndView addProject(@Validated ProjectForm projectForm, BindingResult bindingResult) {

        ModelAndView model = new ModelAndView("redirect:/admin/projects/createProject");

        if (bindingResult.hasErrors()) {
            createProjectPage().addObject("error", "Check the values, man");
            return createProjectPage();
        }

        Project project = new Project();
        project.setName(projectForm.getName());
        project.setDescription(projectForm.getDescription());
        project.setPsd(java.sql.Date.valueOf(projectForm.getPsd()));
        project.setPed(java.sql.Date.valueOf(projectForm.getPed()));
        project.setStatus(statusService.getStatusByName("Not started"));
        projectService.addProject(project);
        return model;

    }

    @RequestMapping(value = "/admin/projects/deleteProject/{id}", method = RequestMethod.POST)
    public ModelAndView deleteProject(@PathVariable Integer id) {

        ModelAndView model = new ModelAndView("redirect:/home/projects");
        projectService.deleteProject(id);
        return model;

    }

    @RequestMapping(value = "/admin/projects/changeStatus/{id}/{statusId}", method = RequestMethod.POST)
    public ModelAndView changeProjectStatus(@PathVariable Integer id, @PathVariable Integer statusId) {

        ModelAndView model = new ModelAndView("redirect:/home/projects/projectdetails/"+id);
        Project project = projectService.getProjectById(id);
        Status status = statusService.getStatusById(statusId);
        if ("Completed".equals(status.getName())) {
            project.setAed(new Date(new java.util.Date().getTime()));
        }
        if ("In progress".equals(status.getName())) {
            project.setAed(null);
        }
        /*Set<Task> tasks = project.getTasks();
        for (Task task: tasks) {
            task.setStatus(status);
            if ("Completed".equals(status.getName())) {
                task.setAed(new Date(new java.util.Date().getTime()));
            }
            taskService.addTask(task);
        }*/
        project.setStatus(status);
        projectService.addProject(project);
        return model;

    }

    @RequestMapping(value = "/home/projects/projectdetails/{id}", method = RequestMethod.GET)
    public ModelAndView projectDetailsId(@PathVariable Integer id) {

        ModelAndView model = new ModelAndView("projectDetails");
        Project project = projectService.getProjectById(id);
        model.addObject("title", "Projects Details - Simple Tracker");
        model.addObject("project", project);
        return model;

    }

    @RequestMapping(value = "/home/projects/projectdetails", method = RequestMethod.GET)
    public ModelAndView projectDetails() {

        ModelAndView model = new ModelAndView("projectDetails");
        return model;

    }
}
