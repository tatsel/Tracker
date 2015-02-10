package by.epamlab.users.model;

import javax.persistence.*;

@Entity
@Table(name = "position", catalog = "trackerdb1")
public class Position {

    private Integer id;
    private String name;
    //private Set<Employee> employees;

    public Position() {
    }

    public Position(String name) {
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
        return id+"; name: "+name;
    }

    /*@OneToMany(mappedBy = "position")
    public Set<Employee> getUsers() {
        return employees;
    }*/

    /*public void setUsers(Set<Employee> employees) {
        this.employees = employees;
    }*/
}
