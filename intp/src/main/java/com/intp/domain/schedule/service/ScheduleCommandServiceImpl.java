package com.intp.domain.schedule.service;


import com.intp.domain.friend.entity.Friend;
import com.intp.domain.schedule.dto.ScheduleRegisterRequestDTO;
import com.intp.domain.schedule.dto.ScheduleRegisterResponseDTO;
import com.intp.domain.schedule.entity.Schedule;
import com.intp.domain.schedule.repository.ScheduleRepository;
import com.intp.domain.user.entity.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional
public class ScheduleCommandServiceImpl implements ScheduleCommandService {

    private final ScheduleRepository scheduleRepository;
//    private final FriendRe
    // 일정 추가
    @Transactional
    public ScheduleRegisterResponseDTO registerSchedule(ScheduleRegisterRequestDTO scheduleRegisterRequestDTO) {
////        Long friendId = friendRepo.findById(request.getFriendId())
////        Friend friend = friendRepo.getFriendId(friendId);
//
////
//
//        //스케줄 찾기~~~
//        Schedule schedule = ScheduleRegisterRequestDTO.toEntity(scheduleRegisterRequestDTO, friend, member);
//        scheduleRepository.save(schedule);

//        return ScheduleRegisterResponseDTO.from(schedule);
        return null;

    }

}
