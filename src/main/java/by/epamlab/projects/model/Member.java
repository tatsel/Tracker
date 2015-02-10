package by.epamlab.projects.model;

import by.epamlab.issues.model.Activity;
import by.epamlab.issues.model.Assignment;
import by.epamlab.users.model.Employee;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "member", catalog = "trackerdb1")
public class Member {

    private Integer id;
    private Project project;
    private Employee employee;
    private Role role;
    private Set<Assignment> assignments;
    private Set<Activity> activities;

    public Member() {
    }

    public Member(Integer id, Project project, Employee employee, Role role, Set<Assignment> assignments, Set<Activity> activities) {
        this.id = id;
        this.project = project;
        this.employee = employee;
        this.role = role;
        this.assignments = assignments;
        this.activities = activities;
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

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "member", orphanRemoval = true)
    public Set<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(Set<Assignment> assignments) {
        this.assignments = assignments;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "member", orphanRemoval = true)
    public Set<Activity> getActivities() {
        return activities;
    }

    public void setActivities(Set<Activity> activities) {
        this.activities = activities;
    }
}
