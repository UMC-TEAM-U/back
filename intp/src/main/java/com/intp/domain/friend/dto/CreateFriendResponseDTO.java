package com.intp.domain.friend.dto;

import com.intp.domain.friend.entity.Friend;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CreateFriendResponseDTO {
    private String level;
    private String nickname;
    private String memo;

    public static CreateFriendResponseDTO from(Friend friend) {
        return CreateFriendResponseDTO.builder()
                .level(friend.getFriendLevel().name())
                .memo(friend.getMemo())
                .nickname(friend.getName())
                .build();
    }
}