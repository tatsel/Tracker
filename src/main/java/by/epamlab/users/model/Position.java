package by.epamlab.users.model;

import javax.persistence.*;

@Entity
@Table(name = "position", catalog = "trackerdb")
public class Position {

    private Integer id;
    private String name;

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

    @Column(name = "NAME", unique = true, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
