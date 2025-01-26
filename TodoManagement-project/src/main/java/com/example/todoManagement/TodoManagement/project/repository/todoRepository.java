package com.example.todoManagement.TodoManagement.project.repository;

import com.example.todoManagement.TodoManagement.project.entity.todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface todoRepository extends JpaRepository<todo,Long> {

}
