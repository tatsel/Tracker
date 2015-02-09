package by.epamlab.web.forms;

import javax.validation.constraints.NotNull;

public class MemberForm {

    @NotNull
    private int employeeId;

    @NotNull
    private String roleName;


    /*@NotNull
    private int roleId;*/

    public MemberForm() {
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

   /* public int getRoleId() {
        return roleId;
    }*/

    /*public void setRoleId(int roleId) {
        this.roleId = roleId;
    }*/

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
