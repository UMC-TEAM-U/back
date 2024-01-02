package com.intp.domain.event.repository;

import com.intp.domain.event.entity.Event;
import com.intp.domain.friend.entity.Friend;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findAllByFriend(Friend friend);
}
