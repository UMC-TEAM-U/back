package com.intp.domain.event.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.intp.domain.event.entity.Event;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EventResponseDTO {
    @JsonProperty("event_name")
    private String eventName;
    private Integer price;

    public static EventResponseDTO from(Event event){
        return CreateEventResponseDTO.builder()
                .eventName(event.getEventName())
                .price(event.getPrice())
                .build();
    }
}
