package by.epamlab.issues.model;

import by.epamlab.projects.model.Project;
import by.epamlab.projects.model.Status;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "task", catalog = "trackerdb1")
public class Task {

    private Integer id;
    private Project project;
    private String description;
    private String summary;
    private Date psd;
    private Date asd;
    private Date ped;
    private Date aed;
    private Status status;

    public Task() {
    }

    public Task(Integer id, Project project, String description, String summary, Date psd, Date asd, Date ped, Date aed, Status status) {
        this.id = id;
        this.project = project;
        this.description = description;
        this.summary = summary;
        this.psd = psd;
        this.asd = asd;
        this.ped = ped;
        this.aed = aed;
        this.status = status;
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
    @JoinColumn(name = "PROJECTID")
    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "summary")
    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Column(name = "psd")
    public Date getPsd() {
        return psd;
    }

    public void setPsd(Date psd) {
        this.psd = psd;
    }

    @Column(name = "ped")
    public Date getPed() {
        return ped;
    }

    public void setPed(Date ped) {
        this.ped = ped;
    }

    @Column(name = "asd")
    public Date getAsd() {
        return asd;
    }

    public void setAsd(Date asd) {
        this.asd = asd;
    }

    @Column(name = "aed")
    public Date getAed() {
        return aed;
    }

    public void setAed(Date aed) {
        this.aed = aed;
    }

    @ManyToOne
    @JoinColumn(name = "STATUSID")
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
