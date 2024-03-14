package com.example.schedulespringbootapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "task_groups")
public class TaskGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(value = AccessLevel.NONE)
    private int id;
    @NotBlank(message = "Task group's description cannot be empty")
    private String description;
    private boolean done;
    @Setter(value = AccessLevel.PACKAGE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "group")
    Set<Task> tasks;
}
