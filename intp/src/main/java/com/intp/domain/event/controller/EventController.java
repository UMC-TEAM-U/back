package com.intp.domain.event.controller;

import com.intp.common.response.ApiResponse;
import com.intp.domain.event.dto.EventRequestDto;
import com.intp.domain.event.dto.EventResponseDto;
import com.intp.domain.event.entity.Event;
import com.intp.domain.event.repository.EventRepository;
import com.intp.domain.event.service.EventService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static com.intp.domain.event.dto.EventRequestDto.toEntity;
@RequestMapping("/api/event")
@RestController
public class EventController {
    private EventRepository eventRepository;
    private EventService eventService;

    @PostMapping("/add")
    public ApiResponse createEvent(@Valid @RequestBody EventRequestDto dto){

        EventResponseDto createdEvent = eventService.createEvent(dto);
        return new ApiResponse(true, "200", "success", createdEvent);
    }

    @GetMapping("/")
    public List<EventResponseDto> getEvent(){
        return eventService.getEvents();
    }

}
