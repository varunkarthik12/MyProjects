package com.example.todoManagement.TodoManagement.project.controller;

import com.example.todoManagement.TodoManagement.project.dto.todoDto;
import com.example.todoManagement.TodoManagement.project.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/todo")
public class todoController {

    @Autowired
    public TodoService ts;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<todoDto> create_todo(@RequestBody @Valid todoDto t1)
    {
        todoDto td  = ts.addTodo(t1);
        return new ResponseEntity<>(td, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("{id}")
    public ResponseEntity<todoDto> get_todo(@PathVariable Long id)
    {
        todoDto retrieved_todo = ts.getTodo(id);
        return new ResponseEntity<>(retrieved_todo,HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping
    public ResponseEntity<List<todoDto>> get_all()
    {
        List<todoDto> todo_list = ts.getAllTodos();
        return new ResponseEntity<>(todo_list,HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping
    public ResponseEntity<todoDto> update_todo(@RequestBody todoDto td)
    {
        Long id = td.getId();
        todoDto update_todo = ts.update_todo(td,id);
        return new ResponseEntity<>(update_todo,HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping
    public ResponseEntity<String> delete_todo (@RequestParam Long id)
    {
        ts.delete_todo(id);
        return ResponseEntity.ok("Todo deleted successfully");
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @PatchMapping("complete")
    public ResponseEntity<todoDto> complete_todo(@RequestParam Long id)
    {
        todoDto completed = ts.complete_todo(id);
        return new ResponseEntity<>(completed,HttpStatus.OK);

    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @PatchMapping("Incomplete")
    public ResponseEntity<todoDto> incomplete_todo (@RequestParam Long id)
    {
        todoDto incomplete = ts.incomplete_todo(id);
        return new ResponseEntity<>(incomplete,HttpStatus.OK);
    }

}
