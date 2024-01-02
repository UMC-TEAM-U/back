package com.intp.domain.friend.service;

import com.intp.common.exception.handler.UserHandler;
import com.intp.common.jwt.SecurityUtil;
import com.intp.common.response.status.ErrorStatus;
import com.intp.domain.friend.dto.CreateFriendRequestDTO;
import com.intp.domain.friend.dto.CreateFriendResponseDTO;
import com.intp.domain.friend.entity.Friend;
import com.intp.domain.friend.repository.FriendRepository;
import com.intp.domain.user.entity.Member;
import com.intp.domain.user.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FriendService {
    private final MemberRepository memberRepository;
    private final FriendRepository friendRepository;
    public CreateFriendResponseDTO createFriend(CreateFriendRequestDTO createFriendRequestDTO) {
        Member member = getMemberFromToken();
        Friend friend = CreateFriendRequestDTO.toEntity(createFriendRequestDTO,member);
        friendRepository.save(friend);
        return CreateFriendResponseDTO.from(friend);
    }


    private Member getMemberFromToken() {
        String userEmail = SecurityUtil.getCurrentUserEmail();
        Member member = memberRepository.findByEmail(userEmail)
                .orElseThrow(() -> new UserHandler(ErrorStatus._UNAUTHORIZED));
        return member;
    }
}
