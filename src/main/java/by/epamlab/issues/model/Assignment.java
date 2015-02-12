package by.epamlab.issues.model;

import by.epamlab.projects.model.Member;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "assigment", catalog = "trackerdb1")
public class Assignment {

    private Integer id;
    private Member member;
    private Task task;
    private Set<Activity> activities;

    public Assignment() {
    }

    public Assignment(Integer id, Member member, Task task, Set<Activity> activities) {
        this.id = id;
        this.member = member;
        this.task = task;
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

    @ManyToOne
    @JoinColumn(name = "MEMBERID")
    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    @OneToOne
    @JoinColumn(name = "TASKID")
    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "assignment")
    public Set<Activity> getActivities() {
        return activities;
    }

    public void setActivities(Set<Activity> activities) {
        this.activities = activities;
    }
}
