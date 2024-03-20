package com.example.schedulespringbootapp.service;

import com.example.schedulespringbootapp.TaskConfigurationProperties;
import com.example.schedulespringbootapp.dto.GroupReadModel;
import com.example.schedulespringbootapp.dto.GroupWriteModel;
import com.example.schedulespringbootapp.model.TaskGroup;
import com.example.schedulespringbootapp.repository.TaskGroupRepository;
import com.example.schedulespringbootapp.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@RequestScope
public class TaskGroupService {

    private final TaskGroupRepository taskGroupRepository;
    private final TaskRepository taskRepository;

    public GroupReadModel createGroup(GroupWriteModel source) {
        TaskGroup result = taskGroupRepository.save(source.toGroup());
        return new GroupReadModel(result);
    }

    public List<GroupReadModel> readAll() {
        return taskGroupRepository.findAll().stream()
                .map(GroupReadModel::new)
                .collect(Collectors.toList());
    }

    public void toggleGroup(int groupId) {
        if (taskRepository.existsByDoneIsFalseAndGroup_Id(groupId)) {
            throw new IllegalStateException("Group has undone tasks.");
        }
        TaskGroup result = taskGroupRepository.findById(groupId)
                .orElseThrow(() -> new IllegalArgumentException("Not found TaskGroup with given id."));
        result.setDone(!result.isDone());
        taskGroupRepository.save(result);
    }
}
