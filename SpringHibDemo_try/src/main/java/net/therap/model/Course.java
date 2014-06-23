package net.therap.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author sanjoy.saha
 * @date 6/17/14
 * @time 3:36 PM
 */
@Entity
@Table(name = "course", uniqueConstraints = {
        @UniqueConstraint(columnNames = "COURSE_ID")
})
public class Course {

    @Id
    @GeneratedValue
    @Column(name = "COURSE_ID", unique = true, nullable = false)
    private int id;

    @Column(name = "COURSE_NAME")
    private String name;

    @ManyToMany(mappedBy = "courses")
    private Set<Student> studentSet = new HashSet<Student>(0);

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
