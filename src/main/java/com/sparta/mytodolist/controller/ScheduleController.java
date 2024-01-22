package com.sparta.mytodolist.controller;

import com.sparta.mytodolist.domain.ScheduleEntity;
import com.sparta.mytodolist.dto.ScheduleRequestDTO;
import com.sparta.mytodolist.dto.ScheduleResponseDTO;
import com.sparta.mytodolist.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todo")
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping("/new")
    public ResponseEntity<Void> createTodo(@RequestBody ScheduleRequestDTO scheduleRequestDTO) {
        scheduleService.saveTodo(scheduleRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<ScheduleResponseDTO> findSchedule(@PathVariable Long id){
        ScheduleResponseDTO schedule = scheduleService.findTodo(id);
        return new ResponseEntity<>(schedule, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<ScheduleResponseDTO>> getTodoList(){
        List<ScheduleResponseDTO> schedules = scheduleService.findAll();
        return new ResponseEntity<>(schedules, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateTodo(@PathVariable Long id, @RequestBody ScheduleRequestDTO scheduleRequestDTO){
        scheduleService.update(id, scheduleRequestDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id, @RequestBody long password){
        scheduleService.deleteTodo(id, password);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
