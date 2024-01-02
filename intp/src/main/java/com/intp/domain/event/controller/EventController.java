package com.intp.domain.event.controller;

import com.intp.common.response.ApiResponse;

import com.intp.domain.event.dto.CreateEventRequestDTO;
import com.intp.domain.event.dto.CreateEventResponseDTO;
import com.intp.domain.event.repository.EventRepository;
import com.intp.domain.event.service.EventService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;


@RestController
public class EventController {
    private EventRepository eventRepository;
    private EventService eventService;

    @PostMapping("/add")
    public ApiResponse createEvent(@Valid @RequestBody CreateEventRequestDTO dto){

        CreateEventResponseDTO createdEvent = eventService.createEvent(dto);
        return new ApiResponse(true, "200", "success", createdEvent);
    }

    @GetMapping("/")
    public List<CreateEventResponseDTO> getEvent(){
        return eventService.getEvents();
    }

}
