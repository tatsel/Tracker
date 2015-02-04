package by.epamlab.web.controller;

import by.epamlab.projects.model.Project;
import by.epamlab.projects.service.ProjectService;
import by.epamlab.users.model.Employee;
import by.epamlab.users.service.PositionService;
import by.epamlab.users.service.UserRoleService;
import by.epamlab.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class HelloController {

    @RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
    public ModelAndView welcomePage() {

        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring Security Hello World");
        model.addObject("message", "This is welcome page!");
        model.setViewName("hello");
        return model;

    }

    @RequestMapping(value = { "/home**" }, method = RequestMethod.GET)
    public ModelAndView homePage() {
        ModelAndView model = new ModelAndView();
        //Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        //String name = auth.getName();
        model.addObject("title", "Home page");
        model.addObject("message", "Congratulations!");
        model.setViewName("home");
        //model.addObject("username", name);
        return model;

    }

    @RequestMapping(value = "/admin**", method = RequestMethod.GET)
    public ModelAndView adminPage() {

        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring Security Hello World");
        model.addObject("message", "This is protected page - Admin Page!");
        model.setViewName("admin");

        return model;

    }

    @RequestMapping(value = "/dba**", method = RequestMethod.GET)
    public ModelAndView dbaPage() {

        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring Security Hello World");
        model.addObject("message", "This is protected page - Database Page!");
        model.setViewName("admin");

        return model;

    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView usersPage() {

        ModelAndView model = new ModelAndView();
        model.addObject("title", "Users list");
        model.addObject("usersList", userService.loadUserList());
        model.setViewName("users");
        return model;

    }

    @Autowired
    private PositionService positionService;
    @Autowired
    private UserRoleService userRoleService;

    @RequestMapping(value = "/users/createUser", method = RequestMethod.GET)
     public ModelAndView createUserPage() {

        ModelAndView model = new ModelAndView();
        model.addObject("title", "Create user");
        model.addObject("positionsList", positionService.loadPositions());
        model.addObject("userRoleList", userRoleService.loadUserRoles());
        model.addObject("user", new Employee());
        model.setViewName("createUser");
        return model;

    }

    @RequestMapping(value = "/users/addUser", method = RequestMethod.POST)
    public ModelAndView addUser(@ModelAttribute("user")Employee user) {

        ModelAndView model = new ModelAndView("redirect:/users/createUser");
        user.setEnabled(true);
        System.out.println(user.getPosition());
        String password = user.getPassword();
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        user.setPassword(hashedPassword);
        user.setPosition(positionService.getPositionByName(user.getPosition().getName()));
        user.setUserRole(userRoleService.getRoleByName(user.getUserRole().getName()));
        System.out.println(user.getUserRole());
        userService.addUser(user);
        return model;

    }

    @RequestMapping(value = "/users/deleteUser/{id}", method = RequestMethod.GET)
    public ModelAndView deleteUser(@PathVariable Integer id) {

        ModelAndView model = new ModelAndView("redirect:/users");
        userService.deleteUser(id);
        System.out.println(id);
        return model;

    }


    @Autowired
    private ProjectService projectService;
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
