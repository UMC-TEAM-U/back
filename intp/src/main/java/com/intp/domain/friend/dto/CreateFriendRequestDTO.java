package com.intp.domain.friend.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.intp.domain.friend.entity.Friend;
import com.intp.domain.friend.entity.FriendLevel;
import com.intp.domain.user.entity.Member;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

@Getter
@Builder
public class CreateFriendRequestDTO {
    @NotNull
    private String nickname;
    @NotNull
    @Range(min = 1,max = 3)
    private Integer level;
    @NotNull
    private String memo;

    public static Friend toEntity(CreateFriendRequestDTO createFriendRequestDTO, Member member) {
        return Friend.builder()
                .friendLevel(FriendLevel.fromLevel(createFriendRequestDTO.getLevel()))
                .member(member)
                .memo(createFriendRequestDTO.getMemo())
                .name(createFriendRequestDTO.getNickname())
                .build();
    }
}
