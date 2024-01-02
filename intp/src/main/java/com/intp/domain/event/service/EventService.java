package com.intp.domain.event.service;


import com.intp.common.exception.handler.FriendHandler;
import com.intp.common.response.status.ErrorStatus;
import com.intp.domain.event.dto.CreateEventRequestDTO;
import com.intp.domain.event.dto.CreateEventResponseDTO;
import com.intp.domain.event.entity.Event;
import com.intp.domain.event.repository.EventRepository;
import com.intp.domain.friend.entity.Friend;
import com.intp.domain.friend.repository.FriendRepository;
import org.springframework.stereotype.Service;

import static com.intp.domain.event.dto.CreateEventRequestDTO.toEntity;

@Service
public class EventService {
    private EventRepository eventRepository;
    private FriendRepository friendRepository;

    public CreateEventResponseDTO createEvent(CreateEventRequestDTO createEventRequestDTO){
        Friend friend = friendRepository.findById(createEventRequestDTO.getFriendId()).orElseThrow(() -> new FriendHandler(ErrorStatus.FRIEND_ARGUMENT_ERROR));
        Event event = CreateEventRequestDTO.toEntity(createEventRequestDTO, friend);
        eventRepository.save(event);
        return CreateEventResponseDTO.from(event);
    }


}
