package by.epamlab.web.controllers;

import by.epamlab.projects.model.Project;
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

@Controller
@RequestMapping
public class ProjectController {

    @Autowired
    private ProjectService projectService;
    @Autowired
    private StatusService statusService;

    @RequestMapping(value = "/projects", method = RequestMethod.GET)
    public ModelAndView projectsPage() {

        ModelAndView model = new ModelAndView();
        model.addObject("title", "Projects list");
        model.addObject("projectsList", projectService.loadProjectList());
        model.setViewName("projects");
        return model;

    }

    @RequestMapping(value = "/projects/createProject", method = RequestMethod.GET)
    public ModelAndView createProjectPage() {

        ModelAndView model = new ModelAndView();
        model.addObject("title", "Create project");
        model.addObject("statusList", statusService.loadStatusList());
        model.addObject("projectForm", new ProjectForm());
        model.setViewName("createProject");
        return model;

    }

    @RequestMapping(value = "/projects/addProject", method = RequestMethod.POST)
    public ModelAndView addProject(@Validated ProjectForm projectForm, BindingResult bindingResult) {

        ModelAndView model = new ModelAndView("redirect:/projects/createProject");

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

    @RequestMapping(value = "/projects/deleteProject/{id}", method = RequestMethod.GET)
    public ModelAndView deleteUser(@PathVariable Integer id) {

        ModelAndView model = new ModelAndView("redirect:/projects");
        projectService.deleteProject(id);
        System.out.println(id);
        return model;

    }
}
