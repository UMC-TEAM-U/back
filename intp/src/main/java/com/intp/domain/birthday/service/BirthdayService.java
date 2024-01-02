package com.intp.domain.birthday.service;


import com.intp.common.exception.handler.UserHandler;
import com.intp.common.jwt.SecurityUtil;
import com.intp.common.response.ApiResponse;
import com.intp.common.response.status.ErrorStatus;
import com.intp.common.response.status.SuccessStatus;
import com.intp.domain.birthday.dto.BirthdayDTO;
import com.intp.domain.birthday.entity.Birthday;
import com.intp.domain.birthday.repository.BirthdayReopository;
import com.intp.domain.friend.entity.Friend;
import com.intp.domain.friend.repository.FriendRepository;
import com.intp.domain.user.entity.Member;
import com.intp.domain.user.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BirthdayService {

    private final BirthdayReopository birthdayReopository;
    private final FriendRepository friendRepository;
    private final MemberRepository memberRepository;

    public ApiResponse add(BirthdayDTO birthdayDTO){

        Friend friend = friendRepository.getReferenceById(birthdayDTO.getFriend_id());
        Birthday birthday = birthdayDTO.toEntity(birthdayDTO,friend);

        birthdayReopository.save(birthday);

        return ApiResponse.of(SuccessStatus._PRESENT_ADD_SUCCESS, "선물 추가 성공!");



    }

    }



