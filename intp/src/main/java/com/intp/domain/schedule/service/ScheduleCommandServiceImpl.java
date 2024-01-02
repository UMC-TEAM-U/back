package com.intp.domain.schedule.service;


import com.intp.common.exception.handler.ScheduleHandler;
import com.intp.common.exception.handler.UserHandler;
import com.intp.common.jwt.SecurityUtil;
import com.intp.common.response.status.ErrorStatus;
import com.intp.domain.friend.entity.Friend;
import com.intp.domain.friend.repository.FriendRepository;
import com.intp.domain.schedule.dto.ScheduleRegisterRequestDTO;
import com.intp.domain.schedule.dto.ScheduleRegisterResponseDTO;
import com.intp.domain.schedule.entity.Schedule;
import com.intp.domain.schedule.repository.ScheduleRepository;
import com.intp.domain.user.entity.Member;
import com.intp.domain.user.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class ScheduleCommandServiceImpl implements ScheduleCommandService {

    private final ScheduleRepository scheduleRepository;
    private final FriendRepository friendRepository;
    private final MemberRepository memberRepository;

    // 일정 추가
    @Transactional
    public ScheduleRegisterResponseDTO registerSchedule(ScheduleRegisterRequestDTO scheduleRegisterRequestDTO) {
        Friend friend = friendRepository.findById(scheduleRegisterRequestDTO.getFriendId()).orElseThrow(() -> new ScheduleHandler(ErrorStatus.SCHEDULE_POST_ARGUMENT_ERROR));

        Schedule schedule = ScheduleRegisterRequestDTO.toEntity(scheduleRegisterRequestDTO, friend);
        scheduleRepository.save(schedule);
        return ScheduleRegisterResponseDTO.from(schedule);

    }

}
