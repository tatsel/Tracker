package by.epamlab.users.model;

import by.epamlab.projects.model.Member;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "employee", catalog = "trackerdb1")
public class Employee {

    private Integer id;
    private String firstname;
    private String lastname;
    private String login;
    private String password;
    private Position position;
    private UserRole userRole;
    private boolean enabled;
    private Set<Member> members;

    public Employee() {}

    public Employee(String firstname, String lastname, String login, String password, Position position, UserRole userRole, Set<Member> members) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.login = login;
        this.password = password;
        this.position = position;
        this.userRole = userRole;
        this.enabled = true;
        this.members = members;

    }

    @Id
    @GeneratedValue
    @Column(name = "ID", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "FIRSTNAME", nullable = false)
    public String getFirstname() {
        return firstname;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Column(name = "LASTNAME")
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Column(name = "LOGIN", unique = true, nullable = false)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "POSITIONID")
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "SITEROLEID")
    public UserRole getUserRole() {
        return this.userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public boolean isEnabled() {
        return enabled;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "employee", orphanRemoval = true)
    public Set<Member> getMembers() {
        return members;
    }

    public void setMembers(Set<Member> members) {
        this.members = members;
    }
}
