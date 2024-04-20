package com.todos.app.demo.student;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class CreateStudentDTO {

    @NotBlank(message = "Name is required")
    @Size(max = 255, message = "Name max is 255")
    public String name;

    @Email(message = "Email should be valid")
    public String email;

    @Past(message = "Date of Birth is required")
    public LocalDate dob;


}