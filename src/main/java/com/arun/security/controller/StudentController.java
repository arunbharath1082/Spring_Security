package com.arun.security.controller;

import com.arun.security.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    List<Student> students = new ArrayList<>(
            List.of(
                    new Student(1, "Arun", 100),
                    new Student(2, "Aruna", 90),
                    new Student(3, "Aruni", 80)
            )
    );

    @GetMapping("/students")
    public List<Student> getStudents(){

        return students;
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody  Student student){
        students.add(student);
        return student;
    }
}
