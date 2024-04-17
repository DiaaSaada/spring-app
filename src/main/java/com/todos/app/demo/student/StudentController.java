package com.todos.app.demo.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping( path = "api/v1/student")
public class StudentController {


    @GetMapping
    public List<Student> getStudents() {
        return java.util.List.of(

                new Student(1,
                        "Bob",
                        "bob@gmail.com",
                        LocalDate.of(2000, Month.JANUARY, 11),
                        22
                ),
                new Student(2,
                        "Alice",
                        "alice@gmail.com",
                        LocalDate.of(2000, Month.JANUARY, 11),
                        22
                )
        );
    }
}
