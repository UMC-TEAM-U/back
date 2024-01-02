package com.intp.domain.birthday.service;



import com.intp.common.exception.handler.FriendHandler;
import com.intp.common.response.ApiResponse;
import com.intp.common.response.status.ErrorStatus;
import com.intp.common.response.status.SuccessStatus;
import com.intp.domain.birthday.dto.CreateBirthdayRequestDTO;
import com.intp.domain.birthday.entity.Birthday;
import com.intp.domain.birthday.repository.BirthdayRepository;
import com.intp.domain.friend.entity.Friend;
import com.intp.domain.friend.repository.FriendRepository;
import com.intp.domain.user.entity.Member;
import com.intp.domain.user.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BirthdayService {

    private final BirthdayRepository birthdayRepository;
    private final FriendRepository friendRepository;
    private final MemberRepository memberRepository;

    public ApiResponse createBirthday(CreateBirthdayRequestDTO birthdayDTO){
        Friend friend = friendRepository.findById(birthdayDTO.getFriend_id()).orElseThrow(() -> new FriendHandler(ErrorStatus._BAD_REQUEST));
        Birthday birthday = birthdayDTO.toEntity(birthdayDTO,friend);
        birthdayRepository.save(birthday);
        return ApiResponse.of(SuccessStatus._PRESENT_ADD_SUCCESS, "선물 추가 성공!");
    }

}