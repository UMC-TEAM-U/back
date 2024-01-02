package com.intp.domain.event.dto;

import com.intp.domain.event.entity.Event;
import com.intp.domain.friend.entity.Friend;
import com.intp.domain.user.entity.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;


@Getter
@Setter
@Builder

public class EventRequestDto {

    @NotNull
    private String event_name;
    @NotNull
    private int price;


    public static Event toEntity(EventRequestDto
                                         eventRequestDto) {
        return Event.builder()
                .event_name(eventRequestDto.getEvent_name())
                .price(eventRequestDto.getPrice())
                .build();
    }
}
