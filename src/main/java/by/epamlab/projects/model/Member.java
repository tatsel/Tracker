package by.epamlab.projects.model;

import by.epamlab.users.model.Employee;

import javax.persistence.*;

@Entity
@Table(name = "member", catalog = "trackerdb")
public class Member {

    private Integer id;
    private Project project;
    private Employee employee;
    private Role role;

    public Member() {
    }

    public Member(Integer id, Project project, Employee employee, Role role) {
        this.id = id;
        this.project = project;
        this.employee = employee;
        this.role = role;
    }

    @Id
    @GeneratedValue
    @Column(name = "ID", nullable = false, unique = true)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "PROJECTID")
    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "EMPLOYEEID")
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "ROLEID")
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
