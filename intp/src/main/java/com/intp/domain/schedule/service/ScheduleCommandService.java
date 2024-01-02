package com.intp.domain.schedule.service;

import com.intp.domain.schedule.dto.ScheduleRegisterRequestDTO;
import com.intp.domain.schedule.dto.ScheduleRegisterResponseDTO;
import com.intp.domain.schedule.entity.Schedule;
import org.springframework.transaction.annotation.Transactional;

public interface ScheduleCommandService {
    @Transactional
    public ScheduleRegisterResponseDTO registerSchedule(ScheduleRegisterRequestDTO scheduleRegisterRequestDTO);
}
