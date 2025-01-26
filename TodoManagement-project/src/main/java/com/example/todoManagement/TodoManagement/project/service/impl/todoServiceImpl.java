package com.example.todoManagement.TodoManagement.project.service.impl;

import com.example.todoManagement.TodoManagement.project.Exception.ResourceNotFoundException;
import com.example.todoManagement.TodoManagement.project.dto.todoDto;
import com.example.todoManagement.TodoManagement.project.entity.todo;
import com.example.todoManagement.TodoManagement.project.repository.todoRepository;
import com.example.todoManagement.TodoManagement.project.service.TodoService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class todoServiceImpl implements TodoService {

    @Autowired
    private todoRepository todoRep;

    @Autowired
    private ModelMapper mod_map;
    @Override
    public todoDto addTodo(todoDto td) {
        todo t1 = mod_map.map(td,todo.class);
        todo saved_todo = todoRep.save(t1);
        todoDto saved = mod_map.map(saved_todo,todoDto.class);

        return saved;
    }

    @Override
    public todoDto getTodo(Long id) {
        todo t1 = todoRep.findById(id).orElseThrow(()-> new ResourceNotFoundException("Todo Not Found with id: "+id));

        todoDto retrieved_todo = mod_map.map(t1,todoDto.class);
        return retrieved_todo;
    }

    @Override
    public List<todoDto> getAllTodos() {
        List<todo> result = todoRep.findAll();

        return result.stream().map((t1)->mod_map.map(t1,todoDto.class)).collect(Collectors.toList());
    }

    @Override
    public todoDto update_todo(todoDto td, Long id) {
       todo result = todoRep.findById(id).orElseThrow(()-> new ResourceNotFoundException("no data found with given: "+id));
       result.setTitle(td.getTitle());
       result.setDescription(td.getDescription());
       result.setCompleted(td.isCompleted());

       todo saved_res = todoRep.save(result);

       todoDto td_res = mod_map.map(saved_res,todoDto.class);
       return td_res;
    }

    @Override
    public void delete_todo(Long id) {
        todo todo_to_delete = todoRep.findById(id).orElseThrow(()-> new ResourceNotFoundException("No data found for the given id: "+id));
        todoRep.deleteById(id);
    }

    @Override
    public todoDto complete_todo(Long id) {
       todo todo_to_complete = todoRep.findById(id).orElseThrow(()->new ResourceNotFoundException("No data found for the given id: "+id));
       todo_to_complete.setCompleted(Boolean.TRUE);
       todo completed_todo = todoRep.save(todo_to_complete);
       todoDto completed_todoDto = mod_map.map(completed_todo, todoDto.class);
       return completed_todoDto;

    }

    @Override
    public todoDto incomplete_todo(Long id) {
        todo todo_to_complete = todoRep.findById(id).orElseThrow(()->new ResourceNotFoundException("No data found for the given id: "+id));
        todo_to_complete.setCompleted(Boolean.FALSE);
        todo completed_todo = todoRep.save(todo_to_complete);
        todoDto completed_todoDto = mod_map.map(completed_todo, todoDto.class);
        return completed_todoDto;
    }
}
