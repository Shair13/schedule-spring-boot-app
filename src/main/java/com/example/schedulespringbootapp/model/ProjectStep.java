package com.example.schedulespringbootapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "project_steps")
@Getter
@Setter
public class ProjectStep {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Project step's description cannot be empty")
    private String description;
    @Getter(value = AccessLevel.PACKAGE)
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;
    private int daysToDeadline;
}
