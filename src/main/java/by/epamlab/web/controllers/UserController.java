package by.epamlab.web.controllers;

import by.epamlab.users.model.Employee;
import by.epamlab.users.service.PositionService;
import by.epamlab.users.service.UserRoleService;
import by.epamlab.users.service.UserService;
import by.epamlab.web.forms.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private PositionService positionService;
    @Autowired
    private UserRoleService userRoleService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView usersPage() {

        ModelAndView model = new ModelAndView();
        model.addObject("title", "Users list");
        model.addObject("usersList", userService.loadUserList());
        model.setViewName("users");
        return model;

    }



    @RequestMapping(value = "/users/createUser", method = RequestMethod.GET)
    public ModelAndView createUserPage() {

        ModelAndView model = new ModelAndView();
        model.addObject("title", "Create user");
        model.addObject("positionsList", positionService.loadPositions());
        model.addObject("userRoleList", userRoleService.loadUserRoles());
        model.addObject("userForm", new UserForm());
        model.setViewName("createUser");
        return model;

    }

    @RequestMapping(value = "/users/addUser", method = RequestMethod.POST)
    public ModelAndView addUser(@Valid UserForm userForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return createUserPage();
        }
        ModelAndView model = new ModelAndView("redirect:/users/createUser");
        Employee user = new Employee();
        String password = userForm.getPassword();
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        String login = userForm.getFirstName()+"_"+userForm.getLastName();
        user.setEnabled(true);
        user.setFirstname(userForm.getFirstName());
        user.setLastname(userForm.getLastName());
        user.setLogin(login);
        user.setPassword(hashedPassword);
        user.setPosition(positionService.getPositionByName(userForm.getPosition()));
        user.setUserRole(userRoleService.getRoleByName(userForm.getUserRole()));
        //System.out.println(user.getUserRole());
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

}
