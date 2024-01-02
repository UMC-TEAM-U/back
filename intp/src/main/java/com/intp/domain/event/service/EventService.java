package com.intp.domain.event.service;


import com.intp.common.exception.handler.FriendHandler;
import com.intp.common.response.status.ErrorStatus;
import com.intp.domain.event.dto.CreateEventRequestDTO;
import com.intp.domain.event.dto.CreateEventResponseDTO;
import com.intp.domain.event.dto.EventResponseDTO;
import com.intp.domain.event.entity.Event;
import com.intp.domain.event.repository.EventRepository;
import com.intp.domain.friend.entity.Friend;
import com.intp.domain.friend.repository.FriendRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EventService {
    private final EventRepository eventRepository;
    private final FriendRepository friendRepository;

    public CreateEventResponseDTO createEvent(CreateEventRequestDTO createEventRequestDTO){
        Friend friend = friendRepository.findById(createEventRequestDTO.getFriendId()).orElseThrow(() -> new FriendHandler(ErrorStatus.FRIEND_ARGUMENT_ERROR));
        Event event = CreateEventRequestDTO.toEntity(createEventRequestDTO, friend);
        eventRepository.save(event);
        return CreateEventResponseDTO.from(event);
    }


    public List<EventResponseDTO> getEvents(Long friendId) {
        Friend friend = friendRepository.findById(friendId).orElseThrow(() -> new FriendHandler(ErrorStatus.FRIEND_ARGUMENT_ERROR));
        List<Event> eventList = eventRepository.findAllByFriend(friend);
        return eventRepository.findAllByFriend(friend).stream()
                .map(EventResponseDTO::from)
                .collect(Collectors.toList());
    }
}
