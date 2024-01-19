package com.sparta.mytodolist.repository;

import com.sparta.mytodolist.domain.Schedule;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ScheduleRepository {

    private final EntityManager em;

    public void save(Schedule schedule){
        if(schedule.getId() == null){
            em.persist(schedule);
        } else{
            em.merge(schedule);
        }

    }

    public Schedule findById(Long id){
        return em.find(Schedule.class, id);
    }

    public List<Schedule> findAll(){
        return em.createQuery("select m from Schedule m", Schedule.class)
                .getResultList();
    }

    public void delete(Long id){
        Schedule schedule = em.find(Schedule.class, id);

        if(schedule != null){
            em.remove(schedule);
        }
    }
}
