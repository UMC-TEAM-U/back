package com.intp.domain.schedule.service;

import com.intp.domain.schedule.dto.ScheduleMonthlyResponseDTO;
import com.intp.domain.schedule.entity.Schedule;

import java.util.List;

public interface ScheduleQueryService {

    public List<ScheduleMonthlyResponseDTO> getMonthlySchedules(Integer targetYear, Integer targetMonth );

    public List<ScheduleMonthlyResponseDTO> getDateSchedules(Integer targetYear, Integer targetMonth, Integer targetDate);

    public Boolean deleteSchedule(Long scheduleId);
}
