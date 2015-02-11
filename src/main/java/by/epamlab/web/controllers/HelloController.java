package by.epamlab.web.controllers;

import by.epamlab.issues.service.ActivityService;
import by.epamlab.issues.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class HelloController {
    @Autowired
    ActivityService activityService;
    @Autowired
    AssignmentService assignmentService;

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public ModelAndView welcomePage() {
        ModelAndView model = new ModelAndView();
        model.addObject("title", "Welcome! - Simple Tracker");
        model.setViewName("hello");
        return model;
    }

    @RequestMapping(value = { "/home" }, method = RequestMethod.GET)
    public ModelAndView homePage() {
        ModelAndView model = new ModelAndView();
        model.addObject("title", "Dashboard - Simple Tracker");
        model.addObject("activities", activityService.loadActivities());
        model.addObject("assignments", assignmentService.loadAssignmentsList());
        model.setViewName("home");
        return model;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginPage() {
        ModelAndView model = new ModelAndView();
        model.addObject("title", "Login - Simple Tracker");
        model.setViewName("login");
        return model;
    }

}
