package com.example.schedulespringbootapp.model;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(value = AccessLevel.NONE)
    private int id;
    @NotBlank(message = "Task's description cannot be empty")
    private String description;
    private boolean done;
    private LocalDateTime deadline;
    @Embedded
    @Setter(value = AccessLevel.NONE)
    @Getter(value = AccessLevel.NONE)
    private Audit audit = new Audit();
    @ManyToOne
    @JoinColumn(name = "task_group_id")
    @Getter(AccessLevel.PACKAGE)
    @Setter(AccessLevel.PACKAGE)
    private TaskGroup group;

    public void updateFrom(final Task source) {
        description = source.description;
        done = source.done;
        deadline = source.deadline;
        group = source.group;
    }
}
