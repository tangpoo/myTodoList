package com.sparta.mytodolist.repository;

import com.sparta.mytodolist.domain.ScheduleEntity;
import com.sparta.mytodolist.dto.ScheduleRequestDTO;
import com.sparta.mytodolist.dto.ScheduleResponseDTO;
import com.sparta.mytodolist.exception.DiffPasswordException;
import com.sparta.mytodolist.exception.NotFoundSchedule;
import com.sparta.mytodolist.exception.NotMatchIdException;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ScheduleRepository {

    private final EntityManager em;

    public void save(ScheduleRequestDTO scheduleRequestDTO) {
        ScheduleEntity scheduleEntity = new ScheduleEntity(scheduleRequestDTO);

        em.persist(scheduleEntity);
    }

    public ScheduleResponseDTO findById(Long id) {
        ScheduleEntity scheduleEntity = em.find(ScheduleEntity.class, id);

        if(scheduleEntity == null){
            throw new NotFoundSchedule();
        }

        return new ScheduleResponseDTO(scheduleEntity);
    }

    public List<ScheduleResponseDTO> findAll() {
        List<ScheduleEntity> scheduleEntityList = em.createQuery("select m from ScheduleEntity m", ScheduleEntity.class).getResultList();
        return scheduleEntityList.stream().map(ScheduleResponseDTO::new)
                .toList();
    }

    public void update(Long id, ScheduleRequestDTO scheduleRequestDTO) {
        ScheduleEntity scheduleEntity = em.find(ScheduleEntity.class, id);

        if(scheduleEntity == null){
            throw new NotMatchIdException();
        }

        if (scheduleEntity.getPassword() != scheduleRequestDTO.getPassword()) {
            throw new DiffPasswordException();
        }

        scheduleEntity.updateTodo(scheduleRequestDTO.getTitle(), scheduleRequestDTO.getUser(), scheduleRequestDTO.getContent());
    }

    public void delete(Long id, long password) {
        ScheduleEntity scheduleEntity = em.find(ScheduleEntity.class, id);

        if(scheduleEntity == null){
            throw new NotMatchIdException();
        }

        if (scheduleEntity.getPassword() != password) {
            throw new DiffPasswordException();
        }

        em.remove(scheduleEntity);
    }
}
