package by.epamlab.issues.model;

import by.epamlab.projects.model.Member;

import javax.persistence.*;

@Entity
@Table(name = "assigment", catalog = "trackerdb1")
public class Assignment {

    private Integer id;
    private Member member;
    private Task task;

    public Assignment() {
    }

    public Assignment(Integer id, Member member, Task task, String description) {
        this.id = id;
        this.member = member;
        this.task = task;
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

}
