package com.demotest.controllers.rest;

import com.demotest.entity.Student;
import com.demotest.util.exceptions.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    @PostConstruct
    public void init() {
        students = new ArrayList<>();
        students.add(new Student("Kiko2", "Mij2", "kikom2@gmail.com"));
        students.add(new Student("Kiko3", "Mij3", "kikom3@gmail.com"));
        students.add(new Student("Kiko4", "Mij4", "kikom4@gmail.com"));
    }


    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        if (studentId >= students.size() || studentId < 0) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }

        return students.get(studentId);
    }

}
