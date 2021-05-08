package com.example.resttodo.controllers;

import com.example.resttodo.entity.Todo;
import com.example.resttodo.repo.TodoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class DataControllers {

    private final TodoRepository todoRepository;

    public DataControllers(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping("/get")
    public List<Todo> getTodo() {
        return todoRepository.findAll();
    }

    @PostMapping("/add")
    public void addTodo(@RequestBody Todo data) {
        data.getAuthor();
        todoRepository.save(data);
    }

    @PostMapping("/update")
    public void updateTodo(@RequestBody Todo data) {
        todoRepository.save(data);
    }

    @PostMapping("/delete")
    public void deleteTodo(@RequestBody Long id) {
        todoRepository.deleteById(id);
    }
}
