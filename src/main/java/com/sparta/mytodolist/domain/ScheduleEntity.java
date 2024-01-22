package com.sparta.mytodolist.domain;

import com.sparta.mytodolist.dto.ScheduleRequestDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ScheduleEntity {

    @Id @GeneratedValue
    @Column(name = "id")
    private Long id;
    private String title;
    private String user;
    private LocalDateTime date;
    private String content;
    private long password;

    public ScheduleEntity(ScheduleRequestDTO scheduleRequestDTO) {
        this.title = scheduleRequestDTO.getTitle();
        this.user = scheduleRequestDTO.getUser();
        this.date = LocalDateTime.now();
        this.content = scheduleRequestDTO.getContent();
        this.password = scheduleRequestDTO.getPassword();
    }

    public void updateTodo(String title, String user, String content) {
        this.title = title;
        this.user = user;
        this.content = content;
    }
}
