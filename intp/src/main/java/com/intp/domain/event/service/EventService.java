//package com.intp.domain.event.service;
//
//
//import com.intp.common.exception.handler.FriendHandler;
//import com.intp.common.response.status.ErrorStatus;
//import com.intp.domain.event.dto.CreateEventRequestDTO;
//import com.intp.domain.event.dto.CreateEventResponseDTO;
//import com.intp.domain.event.entity.Event;
//import com.intp.domain.event.repository.EventRepository;
//import com.intp.domain.friend.entity.Friend;
//import com.intp.domain.friend.repository.FriendRepository;
//import com.intp.domain.user.repository.MemberRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import static com.intp.domain.event.dto.CreateEventRequestDTO.toEntity;
//
//@Service
//public class EventService {
//
//
////    public CreateEventResponseDTO createEvent(CreateEventRequestDTO createEventRequestDTO){
////        Friend friend = friendRepository.findById(createEventRequestDTO.getFriendId()).orElseThrow(() -> new FriendHandler(ErrorStatus.FRIEND_ARGUMENT_ERROR));
////        Event event = CreateEventRequestDTO.toEntity(createEventRequestDTO, friend);
////        eventRepository.save(event);
////        return CreateEventResponseDTO.from(event);
////    }
//    @Autowired
//    private EventRepository eventRepository;
//    @Autowired
//    private MemberRepository memberRepository;
//    @Autowired
//    private FriendRepository friendRepository;
//
//    public CreateEventResponseDTO createEvent(CreateEventRequestDTO eventRequestDto){
//        Event event = toEntity(eventRequestDto);
//        eventRepository.save(event);
//        return CreateEventResponseDTO.from(event);
//    }
//
//    @Transactional
//    public Event update(Long id, EventRequestDto dto) {
//        Event event = eventRepository.findById(id).orElse(null);
//        if (event != null) {
//            Event changed = toEntity(dto);
//            event.setEvent_name(changed.getEvent_name());
//            event.setPrice(changed.getPrice());
//            eventRepository.save(event);
//        }
//        return event;
//    }
//
//    public List<EventResponseDto> getEvents(){
//        List<Event> events = eventRepository.findAllByMember(getMemberFromToken());
//        return events.stream()
//                .map(EventResponseDto::from)
//                .collect(Collectors.toList());
//    }
//
//    private Member getMemberFromToken() {
//        String userEmail = SecurityUtil.getCurrentUserEmail();
//        Member member = memberRepository.findByEmail(userEmail)
//                .orElseThrow(() -> new UserHandler(ErrorStatus._UNAUTHORIZED));
//        return member;
//    }
//
//
//}

package com.intp.domain.event.service;

import com.intp.common.exception.handler.UserHandler;
import com.intp.common.jwt.SecurityUtil;
import com.intp.common.response.status.ErrorStatus;
import com.intp.domain.event.dto.CreateEventRequestDTO;
import com.intp.domain.event.dto.CreateEventResponseDTO;
import com.intp.domain.event.entity.Event;
import com.intp.domain.event.repository.EventRepository;
import com.intp.domain.friend.repository.FriendRepository;
import com.intp.domain.user.entity.Member;
import com.intp.domain.user.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.intp.domain.event.dto.CreateEventRequestDTO.toEntity;


@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private FriendRepository friendRepository;

    public CreateEventResponseDTO createEvent(CreateEventResponseDTO dto){
        Event event = toEntity(dto);
        eventRepository.save(event);
        return eventRequestDto.from(event);
    }

    @Transactional
    public Event update(Long id, CreateEventRequestDTO dto) {
        Event event = eventRepository.findById(id).orElse(null);
        if (event != null) {
            Event changed = toEntity(dto);
            event.setEventName(changed.getEventName());
            event.setPrice(changed.getPrice());
            eventRepository.save(event);
        }
        return event;
    }

    public List<CreateEventResponseDTO> getEvents(){
        List<Event> events = eventRepository.findAllByMember(getMemberFromToken());
        return events.stream()
                .map(CreateEventResponseDTO::from)
                .collect(Collectors.toList());
    }

    private Member getMemberFromToken() {
        String userEmail = SecurityUtil.getCurrentUserEmail();
        Member member = memberRepository.findByEmail(userEmail)
                .orElseThrow(() -> new UserHandler(ErrorStatus._UNAUTHORIZED));
        return member;
    }


}