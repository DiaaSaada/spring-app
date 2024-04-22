package com.todos.app.demo.student;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Comparable {

    @Id
    @SequenceGenerator(name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1

    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    private String name;
    @Getter
    private String email;
    private LocalDate dob;
    @Transient // to be calculated, not sorted
    private int age;

    public Employee(Long id, String name, String email, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.email = email;


    }

    public Employee(String name, String email, LocalDate dob) {

        this.name = name;
        this.dob = dob;
        this.email = email;


    }


    public int getAge() {
        return Period.between(dob, LocalDate.now()).getYears();

    }

    // Using Comparable to sort Students by age
    @Override
    public int compareTo(Object o) {
        Employee student = (Employee) o;
        return this.getAge() - student.getAge();
    }


}
