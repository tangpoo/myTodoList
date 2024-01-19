package com.sparta.mytodolist.service;

import com.sparta.mytodolist.domain.Todo;
import com.sparta.mytodolist.dto.TodoRequestDTO;
import com.sparta.mytodolist.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public void saveTodo(TodoRequestDTO todoRequestDTO){
        Todo todo = new Todo(todoRequestDTO);
        todoRepository.save(todo);
    }

    @Transactional(readOnly = true)
    public Todo findTodo(Long id){
        return todoRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Todo> findAll(){
        return todoRepository.findAll();
    }

    public void update(Todo todo){
        todo.updateTodo(todo);
    }

    public void deleteTodo(Long id){
        todoRepository.delete(id);
    }
}
