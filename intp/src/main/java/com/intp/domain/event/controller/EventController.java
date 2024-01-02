package com.intp.domain.event.controller;

import com.intp.common.response.ApiResponse;
import com.intp.domain.event.dto.EventRequestDto;
import com.intp.domain.event.dto.EventResponseDto;
import com.intp.domain.event.entity.Event;
import com.intp.domain.event.repository.EventRepository;
import com.intp.domain.event.service.EventService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.intp.domain.event.dto.EventRequestDto.toEntity;

@RestController
public class EventController {
    private EventRepository eventRepository;
    private EventService eventService;

    @PostMapping("/event/add")
    public ApiResponse createEvent(@Valid @RequestBody EventRequestDto dto){

        EventResponseDto createdEvent = eventService.createEvent(dto);
        return new ApiResponse(true, "200", "success", createdEvent);
    }
}
