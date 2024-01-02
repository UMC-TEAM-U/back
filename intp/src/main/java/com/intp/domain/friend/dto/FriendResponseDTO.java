package com.intp.domain.friend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.intp.domain.friend.entity.Friend;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class FriendResponseDTO {
    @JsonProperty("friend_id")
    private Long friendId;

    private String level;

    private String name;

    public static FriendResponseDTO from(Friend friend) {
        return FriendResponseDTO.builder()
                .friendId(friend.getId())
                .level(friend.getFriendLevel().name())
                .name(friend.getName())
                .build();
    }
}
