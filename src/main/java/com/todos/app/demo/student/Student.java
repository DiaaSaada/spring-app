package com.todos.app.demo.student;

import java.time.LocalDate;

public class Student {

    private int id;
    private String name;
    private String email;
    private LocalDate dob;
    private int age;

    public Student(int id, String name, String email, LocalDate dob, int age) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.age = age;

    }
    public Student(String name, String email, LocalDate dob, int age) {

        this.name = name;
        this.dob = dob;
        this.age = age;

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public int getAge() {
        return age;
    }

    public void setId(int id) {
        this.id = id;
    }
}
