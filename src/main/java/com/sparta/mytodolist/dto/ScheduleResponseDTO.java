package com.sparta.mytodolist.dto;

import com.sparta.mytodolist.domain.ScheduleEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class ScheduleResponseDTO {

    private Long id;
    private String title;
    private String user;
    private LocalDateTime date;
    private String content;

    public ScheduleResponseDTO(ScheduleEntity scheduleEntity){
        this.id = scheduleEntity.getId();
        this.title = scheduleEntity.getTitle();
        this.user = scheduleEntity.getUser();
        this.date = LocalDateTime.now();
        this.content = scheduleEntity.getContent();
    }

}
