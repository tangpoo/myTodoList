package com.sparta.mytodolist.repository;

import com.sparta.mytodolist.domain.ScheduleEntity;
import com.sparta.mytodolist.dto.ScheduleRequestDTO;
import com.sparta.mytodolist.dto.ScheduleResponseDTO;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ScheduleRepository {

    private final EntityManager em;

    public void save(ScheduleRequestDTO scheduleRequestDTO){
        ScheduleEntity scheduleEntity = new ScheduleEntity(scheduleRequestDTO);

        if(scheduleEntity.getId() == null){
            em.persist(scheduleEntity);
        } else{
            em.merge(scheduleEntity);
        }
    }

    public ScheduleResponseDTO findById(Long id){
        ScheduleEntity scheduleEntity = em.find(ScheduleEntity.class, id);
        return new ScheduleResponseDTO(scheduleEntity);
    }

    public List<ScheduleResponseDTO> findAll(){
        List<ScheduleEntity> scheduleEntityList = em.createQuery("select m from ScheduleEntity m", ScheduleEntity.class).getResultList();
        return scheduleEntityList.stream().map(ScheduleResponseDTO::new)
                .toList();
    }

    public void update(Long id, ScheduleRequestDTO scheduleRequestDTO){
        ScheduleEntity scheduleEntity = new ScheduleEntity(scheduleRequestDTO);
        scheduleEntity.updateTodo(scheduleRequestDTO.getTitle(), scheduleRequestDTO.getUser(), scheduleRequestDTO.getContent());
    }

    public void delete(Long id, long password){
        ScheduleEntity scheduleEntity = em.find(ScheduleEntity.class, id);

        if(scheduleEntity.getPassword() != password){
            System.out.println("비밀번호가 틀렸습니다.");
            return;
        }

        if(scheduleEntity != null){
            em.remove(scheduleEntity);
        }
    }
}
