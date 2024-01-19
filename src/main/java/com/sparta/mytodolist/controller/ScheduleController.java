package com.sparta.mytodolist.controller;

import com.sparta.mytodolist.domain.Schedule;
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

    @GetMapping("/list")
    public List<ScheduleResponseDTO> getTodoList(){
        List<Schedule> scheduleList = scheduleService.findAll();

        return scheduleList.stream().map(ScheduleResponseDTO::new)
                .toList();
    }

    @PutMapping("/update/{id}")
    public void updateTodo(@PathVariable Long id, @RequestBody ScheduleRequestDTO scheduleRequestDTO){
        scheduleService.update(id, scheduleRequestDTO.getTitle(), scheduleRequestDTO.getUser(), scheduleRequestDTO.getContent());
    }

    @DeleteMapping("/delete/{Id}")
    public void deleteTodo(@PathVariable("Id") String Id){
        Long id = Long.parseLong(Id);
        scheduleService.deleteTodo(id);
    }
}
