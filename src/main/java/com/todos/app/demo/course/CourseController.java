package com.todos.app.demo.course;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "api/v1/courses")
public class CourseController {


    private final CourseService courseService;
    CourseRepo courseRepo;
    CourseDTOMapper courseDTOMapper;


    @Autowired
    public CourseController(CourseService courseService
            , CourseRepo courseRepo
            , CourseDTOMapper courseDTOMapper
    ) {

        this.courseService = courseService;
        this.courseRepo = courseRepo;
        this.courseDTOMapper = courseDTOMapper;

    }

    @GetMapping
    public List<CourseDTO> getCourses() {

        return this.courseRepo.findAll().stream().map(courseDTOMapper).collect(Collectors.toList());

    }


    @PostMapping
    public Optional<Course> createStudent(@Valid @RequestBody Course course) {


        return this.courseService.createCourse(course);

    }


}
