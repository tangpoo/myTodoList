package com.sparta.mytodolist.controller;

import com.sparta.mytodolist.domain.Todo;
import com.sparta.mytodolist.dto.TodoRequestDTO;
import com.sparta.mytodolist.dto.TodoResponseDTO;
import com.sparta.mytodolist.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todo")
public class TodoController {

    private final TodoService todoService;

    @PostMapping("/new")
    public void createTodo(@RequestBody TodoRequestDTO todoRequestDTO) {
        todoService.saveTodo(todoRequestDTO);
    }

    @GetMapping("/list")
    public List<TodoResponseDTO> getTodoList(){
        List<Todo> todoList = todoService.findAll();

        return todoList.stream().map(TodoResponseDTO::new)
                .toList();
    }

    @PutMapping("/update")
    public void updateTodo(@PathVariable("id") Long id){
        Todo todo = todoService.findTodo(id);
        todoService.update(todo);
    }

    @GetMapping("/delete")
    public void deleteTodo(@PathVariable("id") Long id){
        todoService.deleteTodo(id);
    }
}
