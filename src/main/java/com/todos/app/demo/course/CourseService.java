package com.todos.app.demo.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CourseService {


    CourseRepo courseRepo;

    @Autowired
    public CourseService(CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }

    public Optional<Course> createCourse(Course course) {
        System.out.println(course);
        return Optional.of(courseRepo.save(course));
    }
}
