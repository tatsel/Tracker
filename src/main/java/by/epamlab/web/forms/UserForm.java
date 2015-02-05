package by.epamlab.web.forms;

import org.hibernate.validator.constraints.ScriptAssert;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@ScriptAssert(lang = "javascript", script = "_this.passwordVerify.equals(_this.password)")
public class UserForm {

    @NotNull
    @Pattern(regexp = "([a-zA-Z]{1,50})")
    private String firstName;

    @NotNull
    @Pattern(regexp = "([a-zA-Z]{1,50})")
    private String lastName;

    @NotNull
    @Pattern(regexp = "^([a-zA-Z0-9@%$,.;]{4,10})")
    private String password;

    @NotNull
    @Pattern(regexp = "^([a-zA-Z0-9@%$,.;]{4,10})")
    private String passwordVerify;

    @NotNull
    private String userRole;

    @NotNull
    private String position;

    public UserForm() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordVerify() {
        return passwordVerify;
    }

    public void setPasswordVerify(String passwordVerify) {
        this.passwordVerify = passwordVerify;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
