package com.todos.app.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Component
public class StudentService {

    private final StudentRepo studentRepo;

    @Autowired
    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }


    public List<Student> getStudents() {
        studentRepo.saveAll(List.of(new Student(
                "Bob",
                "bob@gmail.com",
                LocalDate.of(2000, Month.JANUARY, 11)


        )));
        return studentRepo.findAll();

    }

    public Optional<Student> getStudent(long id) {
        return studentRepo.findById(id);

    }


    public Optional<Student> createStudent(CreateStudentDTO dto) {
        Optional<Student> s = this.studentRepo.findStudentByEmail(dto.email);
        System.out.println(dto.email + "-" + s.isPresent());
        if (s.isPresent()) {
            throw new IllegalStateException("Invalid Email!");
        }
        Student student = new Student(dto.name, dto.email, dto.dob);
        return Optional.of(studentRepo.save(student));

    }

    public void delete(Long id) {
        boolean exists = studentRepo.existsById(id);
        if (!exists)
            throw new IllegalStateException("Student with ID " + id + " does not exist");
        this.studentRepo.deleteById(id);
    }


    @Transactional
    public Student updateStudent(Long id, Student updatedStudent) {

        Optional<Student> original = this.studentRepo.findById(id);

        if (original.isEmpty()) {
            throw new IllegalStateException("Student with ID " + id + " does not exist");
        }

        Student student = original.get();
        if (!updatedStudent.getEmail().isEmpty()) {
            student.setEmail(updatedStudent.getEmail());
        }
        if (!updatedStudent.getName().isEmpty()) {
            student.setName(updatedStudent.getName());
        }

        student.setDob(updatedStudent.getDob());
        return student;
        // return studentRepo.save(student);
    }


}
