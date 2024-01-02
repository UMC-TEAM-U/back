package com.intp.domain.event.dto;

import com.intp.domain.event.entity.Event;
import com.intp.domain.friend.entity.Friend;
import com.intp.domain.user.entity.Member;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class EventResponseDto {

    private String event_content;
    private Integer price;

    public static EventResponseDto from(Event event){
        return EventResponseDto.builder()
                .event_content(event.getEvent_name())
                .price(event.getPrice())
                .build();
    }
}
