package by.epamlab.users.model;

import javax.persistence.*;

@Entity
@Table(name = "siterole", catalog = "trackerdb1")
public class UserRole {

    private Integer id;
    private String name;

    public UserRole(){}

    public UserRole(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue
    @Column(name = "ID", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "NAME", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return id+";"+name;
    }
}
