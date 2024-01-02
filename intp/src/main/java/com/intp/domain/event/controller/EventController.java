package com.intp.domain.event.controller;

import com.intp.common.response.ApiResponse;

import com.intp.domain.event.dto.CreateEventRequestDTO;
import com.intp.domain.event.dto.CreateEventResponseDTO;
import com.intp.domain.event.repository.EventRepository;
import com.intp.domain.event.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/events")
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;

    @PostMapping("")
    public ApiResponse createEvent(@Valid @RequestBody CreateEventRequestDTO createEventRequestDTO){
        CreateEventResponseDTO createdEvent = eventService.createEvent(createEventRequestDTO);
        return ApiResponse.onSuccess(createdEvent);
    }
    @GetMapping("/{friendId}")
    public ApiResponse getEvents(@PathVariable(value = "friendId") Long friendId){
        return ApiResponse.onSuccess(eventService.getEvents(friendId));
    }
}
