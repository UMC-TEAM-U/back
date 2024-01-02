package com.intp.domain.event.service;

import com.intp.domain.event.dto.EventRequestDto;
import com.intp.domain.event.dto.EventResponseDto;
import com.intp.domain.event.entity.Event;
import com.intp.domain.event.repository.EventRepository;
import com.intp.domain.friend.entity.Friend;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import static com.intp.domain.event.dto.EventRequestDto.toEntity;

@Service
public class EventService {
    private EventRepository eventRepository;

    public EventResponseDto createEvent(EventRequestDto eventRequestDto){
        Event event = toEntity(eventRequestDto);
        eventRepository.save(event);
        return EventResponseDto.from(event);
    }


//    public Event update(Long id, EventRequestDto dto){
//        Event changed = toEntity(dto);
//        Event event = eventRepository.findById(id).orElse(null);
//        return changed;
//    }
}
