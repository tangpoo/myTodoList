package com.sparta.mytodolist.dto;

import com.sparta.mytodolist.domain.ScheduleEntity;
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

    public ScheduleResponseDTO(ScheduleEntity scheduleEntity){
        this.id = scheduleEntity.getId();
        this.title = scheduleEntity.getTitle();
        this.user = scheduleEntity.getUser();
        this.date = scheduleEntity.getDate();
        this.content = scheduleEntity.getContent();
    }

}
