package com.todos.app.demo.student;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Component
public class StudentService {

    public List<Student> getStudents() {
        return java.util.List.of(

                new Student(1,
                        "Bob",
                        "bob@gmail.com",
                        LocalDate.of(2000, Month.JANUARY, 11),
                        20
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
