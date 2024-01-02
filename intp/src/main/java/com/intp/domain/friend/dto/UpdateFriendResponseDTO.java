package com.intp.domain.friend.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class UpdateFriendResponseDTO {
    private Long friendId;
    private String reason;
    private LocalDateTime updateTime;
}
