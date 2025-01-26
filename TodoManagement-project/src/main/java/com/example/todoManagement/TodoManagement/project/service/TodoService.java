package com.example.todoManagement.TodoManagement.project.service;

import com.example.todoManagement.TodoManagement.project.dto.todoDto;
import java.util.List;

public interface TodoService {

    todoDto addTodo(todoDto td);

    todoDto getTodo (Long id);

    List<todoDto> getAllTodos();

    todoDto update_todo(todoDto td, Long id);

    void delete_todo (Long id);

    todoDto complete_todo (Long id);

    todoDto incomplete_todo (Long id);

}
