package com.todos.app.demo.course;

import java.util.List;
import java.util.UUID;

public record CourseDTO(UUID id, String title, String description, List<Resource> resources) {


}
