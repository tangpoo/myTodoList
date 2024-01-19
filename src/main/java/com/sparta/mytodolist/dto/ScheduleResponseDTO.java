package com.sparta.mytodolist.dto;

import com.sparta.mytodolist.domain.Schedule;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ScheduleResponseDTO {

    private Long id;
    private String title;
    private String user;
    private Date date;
    private String content;

    public ScheduleResponseDTO(Schedule schedule){
        this.id = schedule.getId();
        this.title = schedule.getTitle();
        this.user = schedule.getUser();
        this.date = schedule.getDate();
        this.content = schedule.getContent();
    }

}
