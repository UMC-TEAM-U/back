package com.intp.domain.event.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.intp.domain.event.entity.Event;
import com.intp.domain.friend.entity.Friend;
import com.intp.domain.user.entity.Member;
import lombok.Getter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
public class CreateEventRequestDTO {
    @NotNull
    @JsonProperty("event_name")
    private String eventName;

    @NotNull
    @Range(min = 0 , message = "0 이상이여야합니다.")
    private int price;

    @JsonProperty("friend_id")
    @NotNull
    private Long friendId;


    public static Event toEntity(CreateEventRequestDTO createEventRequestDTO , Friend friend , Member member) {
        return Event.builder()
                .eventName(createEventRequestDTO.getEventName())
                .price(createEventRequestDTO.getPrice())
                .friend(friend)
                .member(member)
                .build();
    }
}

