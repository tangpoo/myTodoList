package com.sparta.mytodolist.controller;

import com.sparta.mytodolist.domain.ScheduleEntity;
import com.sparta.mytodolist.dto.ScheduleRequestDTO;
import com.sparta.mytodolist.dto.ScheduleResponseDTO;
import com.sparta.mytodolist.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todo")
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping("/new")
    public void createTodo(@RequestBody ScheduleRequestDTO scheduleRequestDTO) {
        scheduleService.saveTodo(scheduleRequestDTO);
    }

    @GetMapping("/find/{id}")
    public ScheduleResponseDTO findSchedule(@PathVariable Long id){
        return scheduleService.findTodo(id);
    }

    @GetMapping("/list")
    public List<ScheduleResponseDTO> getTodoList(){
        return scheduleService.findAll();
    }

    @PutMapping("/update/{id}")
    public void updateTodo(@PathVariable Long id, @RequestBody ScheduleRequestDTO scheduleRequestDTO){
        scheduleService.update(id, scheduleRequestDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTodo(@PathVariable Long id, @RequestBody long password){
        scheduleService.deleteTodo(id, password);
    }
}
