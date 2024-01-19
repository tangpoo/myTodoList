package com.sparta.mytodolist.domain;

import com.sparta.mytodolist.dto.ScheduleRequestDTO;
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
public class Schedule {

    @Id @GeneratedValue
    @Column(name = "id")
    private Long id;
    private String title;
    private String user;
    private Date date;
    private String content;
    private long password;

    public Schedule(ScheduleRequestDTO scheduleRequestDTO) {
        this.title = scheduleRequestDTO.getTitle();
        this.user = scheduleRequestDTO.getUser();
        this.date = scheduleRequestDTO.getDate();
        this.content = scheduleRequestDTO.getContent();
        this.password = scheduleRequestDTO.getPassword();
    }

    public void updateTodo(String title, String user, String content) {
        this.title = title;
        this.user = user;
        this.content = content;
    }
}
