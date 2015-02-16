package by.epamlab.issues.model;

import by.epamlab.projects.model.Project;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@Table(name = "attachment", catalog = "trackerdb1")
public class Attachment {

    private Integer id;

    private String name;

    private String size;

    private String description;

    private String contenttype;

    private Blob content;

    private Project project;

    private Task task;

    public Attachment() {
    }

    public Attachment(String name, String size, String description, Blob content, Project project, Task task, String contenttype) {
        this.name = name;
        this.size = size;
        this.description = description;
        this.content = content;
        this.project = project;
        this.task = task;
        this.contenttype = contenttype;
    }

    @Id
    @GeneratedValue
    @Column(name="ID", nullable = false, unique = true)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name="NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "SIZE")
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Column(name="DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name="content")
    @Lob
    public Blob getContent() {
        return content;
    }

    public void setContent(Blob content) {
        this.content = content;
    }

    @ManyToOne
    @JoinColumn(name = "PROJECTID")
    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @ManyToOne
    @JoinColumn(name = "TASKID")
    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    @Column(name = "contenttype")
    public String getContenttype() {
        return contenttype;
    }

    public void setContenttype(String contenttype) {
        this.contenttype = contenttype;
    }
}
