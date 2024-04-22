package com.todos.app.demo.course;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Data
@EqualsAndHashCode
@Entity
@Table(name = "resources")
public class Resource {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;


    @NotNull
    private String title;

    @NotNull
    @Column(unique = true, nullable = false)
    private String code;


    /*@ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;*/

}
