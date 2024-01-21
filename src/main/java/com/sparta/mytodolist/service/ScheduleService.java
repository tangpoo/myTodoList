package com.sparta.mytodolist.service;

import com.sparta.mytodolist.domain.ScheduleEntity;
import com.sparta.mytodolist.dto.ScheduleRequestDTO;
import com.sparta.mytodolist.dto.ScheduleResponseDTO;
import com.sparta.mytodolist.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Transactional
    public void saveTodo(ScheduleRequestDTO scheduleRequestDTO){
        scheduleRepository.save(scheduleRequestDTO);
    }

    public ScheduleResponseDTO findTodo(Long id){
        return scheduleRepository.findById(id);
    }

    public List<ScheduleResponseDTO> findAll(){
        return scheduleRepository.findAll();
    }

    @Transactional
    public void update(Long Id, ScheduleRequestDTO scheduleRequestDTO){
        scheduleRepository.update(Id, scheduleRequestDTO);
    }

    @Transactional
    public void deleteTodo(Long id, long password){
        scheduleRepository.delete(id, password);
    }
}
