package com.todos.app.demo.course;

import com.todos.app.demo.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

/**
 * All together now: A shortcut for @ToString, @EqualsAndHashCode, @Getter
 * on all fields, and @Setter on all non-final fields,
 * and @RequiredArgsConstructor!
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table
public class Course extends BaseEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @NotNull
    private String name;

    @NotNull
    private String code;

    @NotNull
    private String description;


}
