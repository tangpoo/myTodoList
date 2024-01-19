package com.sparta.mytodolist.dto;

import lombok.Getter;

import java.util.Date;

@Getter
public class TodoRequestDTO {

    private String user;
    private String title;
    private Date date;
    private String content;
    private long password;

    public TodoRequestDTO(String user, String title, Date date, String content, long password) {
        this.user = user;
        this.title = title;
        this.date = date;
        this.content = content;
        this.password = password;
    }
}
