package by.epamlab.web.forms;

import javax.validation.constraints.NotNull;

public class AssigneeForm {

    @NotNull
    private int memberId;

    public AssigneeForm() {
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }
}
