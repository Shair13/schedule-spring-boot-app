package com.example.schedulespringbootapp.repository;


import com.example.schedulespringbootapp.model.Project;
import com.example.schedulespringbootapp.model.TaskGroup;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository {

    List<Project> findAll();
    Optional<Project> findById(Integer id);
    Project save(Project entity);
}
