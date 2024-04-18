package com.todos.app.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {


    private final StudentService studentService;


    @Autowired
    public StudentController(StudentService studentService, StudentRepo studentRepo) {
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

    @DeleteMapping(path = "{studentId}")
    public Object delete(@PathVariable("studentId") Long id) {

        this.studentService.delete(id);
        return new Object() {
            final boolean success = true;
        };

    }


    @PutMapping(path = "{studentId}")
    public Student updateStudent(@PathVariable("studentId") Long id, @RequestBody Student student) {


        return this.studentService.updateStudent(id, student);


    }
}
