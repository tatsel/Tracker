package by.epamlab.web.controllers;

import by.epamlab.projects.model.Project;
import by.epamlab.projects.service.ProjectService;
import by.epamlab.users.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class ProjectController {

    @Autowired
    private ProjectService projectService;
    @Autowired
    private PositionService positionService;

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
        model.addObject("statusList", positionService.loadPositions());

        model.addObject("project", new Project());
        model.setViewName("createProject");
        return model;

    }

    @RequestMapping(value = "/projects/addProject", method = RequestMethod.POST)
    public ModelAndView addProject(@ModelAttribute("project")Project project) {

        ModelAndView model = new ModelAndView("redirect:/projects/createProject");
        //projectService.addProject(project);
        return model;

    }
}
