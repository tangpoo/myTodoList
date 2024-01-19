package com.sparta.mytodolist.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ScheduleRequestDTO {

    private String user;
    private String title;
    private Date date;
    private String content;
    private long password;

    public ScheduleRequestDTO(String user, String title, Date date, String content, long password) {
        this.user = user;
        this.title = title;
        this.date = date;
        this.content = content;
        this.password = password;
    }
}
