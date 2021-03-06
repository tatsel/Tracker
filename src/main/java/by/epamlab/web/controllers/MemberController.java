package by.epamlab.web.controllers;

import by.epamlab.projects.model.Member;
import by.epamlab.projects.service.MemberService;
import by.epamlab.projects.service.ProjectService;
import by.epamlab.projects.service.RoleService;
import by.epamlab.users.model.Employee;
import by.epamlab.users.service.UserService;
import by.epamlab.web.forms.MemberForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping
public class MemberController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private UserService userService;
    @Autowired
    private MemberService memberService;


    @RequestMapping(value = "/admin/projects/createMember/{id}", method = RequestMethod.GET)
     public ModelAndView createMemberPage(@PathVariable Integer id) {

        ModelAndView model = new ModelAndView();
        List<Employee> employees = userService.loadUsersNotMembers(projectService.getProjectById(id));
        model.addObject("project", projectService.getProjectById(id));
        model.addObject("roles", roleService.loadRoleList());
        model.addObject("employees", employees);
        model.addObject("noEmployees", employees.isEmpty());
        model.addObject("memberForm", new MemberForm());
        model.addObject("title", "Create Member - Simple Tracker");
        model.setViewName("createMember");
        return model;

    }

    @RequestMapping(value = "/admin/projects/addMember/{id}", method = RequestMethod.POST)
    public ModelAndView addProject(@Validated MemberForm memberForm, BindingResult bindingResult, @PathVariable Integer id) {

        ModelAndView model = new ModelAndView("redirect:/admin/projects/createMember/"+id);

        if (bindingResult.hasErrors()) {
            return createMemberPage(id);
        }
        Member member = new Member();
        member.setProject(projectService.getProjectById(id));
        member.setEmployee(userService.getUserById(memberForm.getEmployeeId()));
        member.setRole(roleService.getRoleByName(memberForm.getRoleName()));
        memberService.addMember(member);
        return model;

    }

    @RequestMapping(value = "/admin/projects/deleteMember/{projectId}/{memberId}", method = RequestMethod.POST)
    public ModelAndView deleteMember(@PathVariable Integer projectId, @PathVariable Integer memberId) {

        ModelAndView model = new ModelAndView("redirect:/home/projects/projectdetails/"+projectId);
        memberService.deleteMember(memberId);
        return model;

    }
}
