package com.intp.domain.friend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UpdateFriendRequestDTO {

    private String reason;

    @JsonProperty("friend_id")
    private Long friendId;

    private Integer level;
}
