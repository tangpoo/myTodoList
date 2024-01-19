package com.sparta.mytodolist.repository;

import com.sparta.mytodolist.domain.Todo;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TodoRepository {

    private final EntityManager em;

    public void save(Todo todo){
        if(todo.getId() == null){
            em.persist(todo);
        } else{
            em.merge(todo);
        }

    }

    public Todo findById(Long id){
        return em.find(Todo.class, id);
    }

    public List<Todo> findAll(){
        return em.createQuery("select m from Todo m", Todo.class)
                .getResultList();
    }

    public void delete(Long id){
        Todo todo = em.find(Todo.class, id);

        if(todo != null){
            em.remove(todo);
        }
    }
}
