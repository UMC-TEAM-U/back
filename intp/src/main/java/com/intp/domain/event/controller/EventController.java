package com.intp.domain.event.controller;

import com.intp.common.response.ApiResponse;

import com.intp.common.response.status.ErrorStatus;
import com.intp.domain.event.dto.CreateEventRequestDTO;
import com.intp.domain.event.dto.CreateEventResponseDTO;
import com.intp.domain.event.repository.EventRepository;
import com.intp.domain.event.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.intp.common.util.ValidationUtils.getValidationErrors;


@RestController
@RequestMapping("/api/events")
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;

    @CrossOrigin
    @PostMapping("")
    public ApiResponse createEvent(@Valid @RequestBody CreateEventRequestDTO createEventRequestDTO, Errors errors){
        if (errors.hasErrors()) {
            return ApiResponse.ofFailure(ErrorStatus.EVENT_ERROR, getValidationErrors(errors));
        }
        CreateEventResponseDTO createdEvent = eventService.createEvent(createEventRequestDTO);
        return ApiResponse.onSuccess(createdEvent);
    }
    @CrossOrigin
    @GetMapping("/{friendId}")
    public ApiResponse getEvents(@PathVariable(value = "friendId") Long friendId){
        return ApiResponse.onSuccess(eventService.getEvents(friendId));
    }
}
