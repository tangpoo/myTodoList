package com.sparta.mytodolist.dto;

import com.sparta.mytodolist.domain.Todo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
public class TodoResponseDTO {

    private Long id;
    private String title;
    private String user;
    private Date date;
    private String content;

    public TodoResponseDTO(Todo todo){
        this.id = todo.getId();
        this.title = todo.getTitle();
        this.user = todo.getUser();
        this.date = todo.getDate();
        this.content = todo.getContent();
    }

}
