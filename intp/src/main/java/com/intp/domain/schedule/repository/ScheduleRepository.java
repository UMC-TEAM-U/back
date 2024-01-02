package com.intp.domain.schedule.repository;

import com.intp.domain.schedule.entity.Schedule;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@RequiredArgsConstructor
public class ScheduleRepository {

    @PersistenceContext
    private EntityManager em;

    // 일정 : 저장, 삭제, 수정
    public void save(Schedule schedule){
        em.persist(schedule);
    }

    public void delete(Schedule schedule){
        em.remove(schedule);
    }

    public void update(Schedule schedule){
        em.merge(schedule);
    }
}
