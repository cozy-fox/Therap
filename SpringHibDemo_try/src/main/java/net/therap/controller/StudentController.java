package net.therap.controller;

import net.therap.model.Course;
import net.therap.model.Student;
import net.therap.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

/**
 * @author sanjoy.saha
 * @date 6/12/14
 * @time 4:17 PM
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/add")
    public String addNewStudent() {
        Student student = new Student();
        student.setName("Sanjay");

        // Adding the Courses for the user: Sanjay
        // Assuming Three Courses were attended by him:
        // 1) CSE101, 2) CSE405 and 3) CSE203
//        Set<Course> courses = new HashSet<Course>(0);
        String courseNames[] = {"CSE101", "CSE203", "CSE405"};
        for(int i = 0; i < 3; i++) {
            Course tmpCourse = new Course();
            tmpCourse.setName(courseNames[i]);
            student.getCourseSet().add(tmpCourse);
        }
        studentService.addStudent(student);

        return "student";
    }
}
