package com.example.schedulespringbootapp.repository;

import com.example.schedulespringbootapp.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
interface SqlTaskRepository extends TaskRepository, JpaRepository<Task, Integer> {
}
