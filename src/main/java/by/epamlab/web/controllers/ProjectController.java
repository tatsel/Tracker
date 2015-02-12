package by.epamlab.web.controllers;

import by.epamlab.issues.model.Task;
import by.epamlab.issues.service.TaskService;
import by.epamlab.projects.model.Project;
import by.epamlab.projects.model.Status;
import by.epamlab.projects.service.ProjectService;
import by.epamlab.projects.service.StatusService;
import by.epamlab.web.forms.ProjectForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Set;

@Controller
@RequestMapping
public class ProjectController {

    @Autowired
    private ProjectService projectService;
    @Autowired
    private StatusService statusService;
    @Autowired
    private TaskService taskService;

    @RequestMapping(value = "/home/projects", method = RequestMethod.GET)
    public ModelAndView projectsPage() {

        ModelAndView model = new ModelAndView();
        model.addObject("title", "Projects - Simple Tracker");
        model.addObject("projectsList", projectService.loadProjectList());
        model.setViewName("projects");
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

    @RequestMapping(value = "/admin/projects/deleteProject/{id}", method = RequestMethod.GET)
    public ModelAndView deleteProject(@PathVariable Integer id) {

        ModelAndView model = new ModelAndView("redirect:/home/projects");
        projectService.deleteProject(id);
        return model;

    }

    @RequestMapping(value = "/admin/projects/changeStatus/{id}/{statusId}", method = RequestMethod.GET)
    public ModelAndView suspendProject(@PathVariable Integer id, @PathVariable Integer statusId) {

        ModelAndView model = new ModelAndView("redirect:/home/projects/projectdetails/"+id);
        Project project = projectService.getProjectById(id);
        Status status = statusService.getStatusById(statusId);
        project.setStatus(status);
        Set<Task> tasks = project.getTasks();
        for (Task task: tasks) {
            task.setStatus(status);
            taskService.addTask(task);
        }
        projectService.addProject(project);
        return model;

    }

    @RequestMapping(value = "/home/projects/projectdetails/{id}", method = RequestMethod.GET)
    public ModelAndView projectDetailsId(@PathVariable Integer id) {

        ModelAndView model = new ModelAndView("projectDetails");
        Project project = projectService.getProjectById(id);
        model.addObject("project", project);
        return model;

    }

    @RequestMapping(value = "/home/projects/projectdetails", method = RequestMethod.GET)
    public ModelAndView projectDetails() {

        ModelAndView model = new ModelAndView("projectDetails");
        model.addObject("title", "Project Details - Simple Tracker");
        return model;

    }
}
