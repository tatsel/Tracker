package by.epamlab.projects.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "project", catalog = "trackerdb")
public class Project {

    private Integer id;
    private String name;
    private String description;
    private Date psd;
    private Date ped;
    private Date asd;
    private Date aed;
    private Status status;
    private Set<Member> members;

    public Project() {
    }

    public Project(Integer id, String name, String description, Date psd, Date ped, Date asd, Date aed, Status status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.psd = psd;
        this.ped = ped;
        this.asd = asd;
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

    @Column(name = "name", nullable = false, unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "STATUSID")
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "project", cascade = CascadeType.ALL)
    public Set<Member> getMembers() {
        return members;
    }

    public void setMembers(Set<Member> members) {
        this.members = members;
    }
}
