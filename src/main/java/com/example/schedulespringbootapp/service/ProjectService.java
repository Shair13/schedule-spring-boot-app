package com.example.schedulespringbootapp.service;

import com.example.schedulespringbootapp.TaskConfigurationProperties;
import com.example.schedulespringbootapp.dto.GroupReadModel;
import com.example.schedulespringbootapp.model.Project;
import com.example.schedulespringbootapp.model.Task;
import com.example.schedulespringbootapp.model.TaskGroup;
import com.example.schedulespringbootapp.repository.ProjectRepository;
import com.example.schedulespringbootapp.repository.TaskGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final TaskGroupRepository taskGroupRepository;
    private final TaskConfigurationProperties config;

    public List<Project> readAll() {
        return projectRepository.findAll();
    }

    public Project save(final Project toSave) {
        return projectRepository.save(toSave);
    }

    public GroupReadModel createGroup(LocalDateTime deadline, int projectId) {
        if (config.getTemplate().isAllowMultipleTasks() && taskGroupRepository.existsByDoneIsFalseAndProject_Id(projectId)) {
            throw new IllegalStateException("Only one undone group from project is allowed");
        }
        TaskGroup taskGroupResult = projectRepository.findById(projectId)
                .map(project -> {
                    var result = new TaskGroup();
                    result.setDescription(project.getDescription());
                    result.setTasks(
                            project.getSteps().stream()
                                    .map(step -> new Task(
                                            step.getDescription(),
                                            deadline.plusDays(step.getDaysToDeadline())
                                    )).collect(Collectors.toSet()));
                    return result;
                }).orElseThrow(() -> new IllegalArgumentException("Project with given id not found"));

        return new GroupReadModel(taskGroupResult);
    }
}
