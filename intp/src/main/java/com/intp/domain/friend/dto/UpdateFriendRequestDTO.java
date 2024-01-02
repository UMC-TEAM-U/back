package com.intp.domain.friend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

@Getter
@Builder
public class UpdateFriendRequestDTO {

    @NotNull
    private String reason;

    @JsonProperty("friend_id")
    @NotNull
    private Long friendId;

    @Range(min = 1, max = 3)
    private Integer level;
}
