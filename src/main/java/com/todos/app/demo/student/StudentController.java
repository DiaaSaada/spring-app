package com.todos.app.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping( path = "api/v1/student")
public class StudentController {


    private final StudentService studentService;

    @Autowired
    public StudentController( StudentService  studentService ) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents() {

        return this.studentService.getStudents();

    }


    @PostMapping
    public Optional<Student> createStudent(@RequestBody Student student) {

          return this.studentService.createStudent(student);

    }
}
