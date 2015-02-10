package by.epamlab.issues.model;

import by.epamlab.projects.model.Member;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "activity", catalog = "trackerdb1")
public class Activity {

    private Integer id;
    private Date date;
    private String comment;
    private Member member;
    private Assignment assignment;

    public Activity() {
    }

    public Activity(Integer id, Date date, String comment, Member member, Assignment assignment) {
        this.id = id;
        this.date = date;
        this.comment = comment;
        this.member = member;
        this.assignment = assignment;
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

    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column(name = "comment")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @ManyToOne
    @JoinColumn(name = "MEMBERID")
    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    @ManyToOne
    @JoinColumn(name = "ASSIGMENTID")
    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }
}
