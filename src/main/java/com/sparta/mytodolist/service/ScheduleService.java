package com.sparta.mytodolist.service;

import com.sparta.mytodolist.domain.Schedule;
import com.sparta.mytodolist.dto.ScheduleRequestDTO;
import com.sparta.mytodolist.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public void saveTodo(ScheduleRequestDTO scheduleRequestDTO){
        Schedule schedule = new Schedule(scheduleRequestDTO);
        scheduleRepository.save(schedule);
    }

    @Transactional(readOnly = true)
    public Schedule findTodo(Long id){
        return scheduleRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Schedule> findAll(){
        return scheduleRepository.findAll();
    }

    public void update(Long Id, String title, String user, String content){
        Schedule schedule = scheduleRepository.findById(Id);
        schedule.updateTodo(title, user, content);
    }

    public void deleteTodo(Long id){
        scheduleRepository.delete(id);
    }
}
