package com.example.schedulespringbootapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "projects")
@NoArgsConstructor
@Getter
@Setter(value = AccessLevel.PACKAGE)
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Project's description cannot be empty")
    private String description;
    @Setter(value = AccessLevel.PACKAGE)
    @Getter(value = AccessLevel.PACKAGE)
    @OneToMany(mappedBy = "project")
    Set<TaskGroup> groups;
    @Setter(value = AccessLevel.PACKAGE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
    Set<ProjectStep> steps;

}
