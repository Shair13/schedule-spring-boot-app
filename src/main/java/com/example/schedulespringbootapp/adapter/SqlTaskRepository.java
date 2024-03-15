package com.example.schedulespringbootapp.adapter;

import com.example.schedulespringbootapp.model.Task;
import com.example.schedulespringbootapp.repository.TaskRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
interface SqlTaskRepository extends TaskRepository, JpaRepository<Task, Integer> {

    @Override
    boolean existsByDoneIsFalseAndGroup_Id(Integer groupId);
}
