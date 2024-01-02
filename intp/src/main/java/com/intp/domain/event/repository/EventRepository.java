package com.intp.domain.event.repository;

import com.intp.domain.event.entity.Event;
import com.intp.domain.user.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findAllByMember(Member member);
}
