package com.intp.domain.event.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.intp.domain.event.entity.Event;
import com.intp.domain.friend.entity.Friend;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class CreateEventRequestDTO {
    @NotNull
    @JsonProperty("event_name")
    private String eventName;
    @NotNull
    private int price;

    @JsonProperty("friend_id")
    @NotNull
    private Long friendId;


    public static Event toEntity(CreateEventRequestDTO
                                         createEventRequestDTO , Friend friend) {
        return Event.builder()
                .eventName(createEventRequestDTO.getEventName())
                .price(createEventRequestDTO.getPrice())
                .friend(friend)
                .build();
    }
}

