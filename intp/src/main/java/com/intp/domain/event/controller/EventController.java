package com.intp.domain.event.controller;

import com.intp.common.response.ApiResponse;

import com.intp.common.response.status.ErrorStatus;
import com.intp.domain.event.dto.CreateEventRequestDTO;
import com.intp.domain.event.dto.CreateEventResponseDTO;
import com.intp.domain.event.repository.EventRepository;
import com.intp.domain.event.service.EventService;
import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "경조사 참가한 친구 생성 API")
    @PostMapping("")
    public ApiResponse createEvent(@Valid @RequestBody CreateEventRequestDTO createEventRequestDTO, Errors errors){
        if (errors.hasErrors()) {
            return ApiResponse.ofFailure(ErrorStatus.EVENT_ERROR, getValidationErrors(errors));
        }
        CreateEventResponseDTO createdEvent = eventService.createEvent(createEventRequestDTO);
        return ApiResponse.onSuccess(createdEvent);
    }
    @CrossOrigin
    @Operation(summary = "친구의 경조사 참여내역 조회 API")
    @GetMapping("/{friendId}")
    public ApiResponse getEvents(@PathVariable(value = "friendId") Long friendId){
        return ApiResponse.onSuccess(eventService.getEvents(friendId));
    }
}
