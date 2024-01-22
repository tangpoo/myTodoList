package com.sparta.mytodolist.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class ScheduleRequestDTO {

    private String user;
    private String title;
    private LocalDateTime date;
    private String content;
    private long password;

    public ScheduleRequestDTO(String user, String title, String content, long password) {
        this.user = user;
        this.title = title;
        this.date = LocalDateTime.now();
        this.content = content;
        this.password = password;
    }
}
