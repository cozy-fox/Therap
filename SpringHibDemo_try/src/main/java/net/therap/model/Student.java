package net.therap.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author sanjoy.saha
 * @date 6/9/14
 * @time 11:48 AM
 */

@Entity
@Table(name = "student", uniqueConstraints = {
        @UniqueConstraint(columnNames = "STUDENT_ID")
})
public class Student {


    @Id
    @GeneratedValue
    @Column(name = "STUDENT_ID", unique = true, nullable = false)
    private int id;

    @Column(name = "STUDENT_NAME")
    private String name;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "student_course",
                joinColumns = {@JoinColumn(name = "STUDENT_ID")},
                inverseJoinColumns = {@JoinColumn(name = "COURSE_ID")})
    private Set<Course> courses = new HashSet<Course>(0);

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

    public Set<Course> getCourseSet() {
        return courses;
    }

    public void setCourseSet(Set<Course> courseSet) {
        this.courses = courseSet;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}