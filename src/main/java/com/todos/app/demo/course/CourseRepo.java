package com.todos.app.demo.course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepo extends JpaRepository<Course, Long> {


    @Query("SELECT s FROM Course s WHERE s.code = ?1")
    Optional<Course> findCourseByCode(String code);


}
