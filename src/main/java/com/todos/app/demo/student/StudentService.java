package com.todos.app.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Component
public class StudentService {

    private final StudentRepo studentRepo;

    @Autowired
    public StudentService(  StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }


    public List<Student> getStudents() {
        studentRepo.saveAll( List.of(new Student(
                "Bob",
                "bob@gmail.com",
                LocalDate.of(2000, Month.JANUARY, 11)


        )));
        return studentRepo.findAll();

    }

    public Optional<Student> getStudent(long id) {
        return studentRepo.findById(id);

    }


    public Optional<Student> createStudent(long id) {


        return Optional.empty();
    }
}
