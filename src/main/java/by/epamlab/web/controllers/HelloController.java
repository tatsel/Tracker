package by.epamlab.web.controllers;

import by.epamlab.issues.service.ActivityService;
import by.epamlab.issues.service.AssignmentService;
import by.epamlab.users.model.Employee;
import by.epamlab.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
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
    UserService userService;
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
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = user.getUsername();
        Employee employee = userService.findUserByLogin(name);
        model.addObject("title", "Dashboard - Simple Tracker");
        model.addObject("activities", activityService.loadActivities());
        model.addObject("employee", employee);
        model.setViewName("home");
        return model;
    }

    @RequestMapping(value = { "/home/mypage" }, method = RequestMethod.GET)
    public ModelAndView myPage() {
        ModelAndView model = new ModelAndView();
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = user.getUsername();
        Employee employee = userService.findUserByLogin(name);
        model.addObject("title", "My Page - Simple Tracker");
        model.addObject("employee", employee);
        model.setViewName("mypage");
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
