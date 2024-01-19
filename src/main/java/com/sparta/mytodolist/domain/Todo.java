package com.sparta.mytodolist.domain;

import com.sparta.mytodolist.dto.TodoRequestDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Todo {

    @Id @GeneratedValue
    @Column(name = "id")
    private Long id;
    private String title;
    private String user;
    private Date date;
    private String content;
    private long password;

    public Todo(TodoRequestDTO todoRequestDTO) {
        this.title = todoRequestDTO.getTitle();
        this.user = todoRequestDTO.getUser();
        this.date = todoRequestDTO.getDate();
        this.content = todoRequestDTO.getContent();
        this.password = todoRequestDTO.getPassword();
    }

    public void updateTodo(Todo todo) {
        this.title = todo.getTitle();
        this.user = todo.getUser();
        this.content = todo.getContent();
    }
}
