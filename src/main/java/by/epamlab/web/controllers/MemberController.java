package by.epamlab.web.controllers;

import by.epamlab.projects.model.Member;
import by.epamlab.projects.service.MemberService;
import by.epamlab.projects.service.ProjectService;
import by.epamlab.projects.service.RoleService;
import by.epamlab.users.service.UserService;
import by.epamlab.web.forms.MemberForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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


    @RequestMapping(value = "/admin/projects/createMember", method = RequestMethod.GET)
    public ModelAndView createMemberPage() {

        ModelAndView model = new ModelAndView();
        model.addObject("roles", roleService.loadRoleList());
        model.addObject("memberForm", new MemberForm());
        model.setViewName("createMember");
        return model;

    }

    @RequestMapping(value = "/admin/projects/addMember", method = RequestMethod.POST)
    public ModelAndView addProject(@Validated MemberForm memberForm, BindingResult bindingResult) {

        ModelAndView model = new ModelAndView("redirect:/admin/projects/createMember");

        if (bindingResult.hasErrors()) {
            return createMemberPage();
        }
        Member member = new Member();
        member.setProject(projectService.getProjectById(memberForm.getProjectId()));
        member.setEmployee(userService.getUserById(memberForm.getEmployeeId()));
        member.setRole(roleService.getRoleByName(memberForm.getRoleName()));
        memberService.addMember(member);
        return model;

    }
}
