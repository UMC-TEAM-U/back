package com.intp.domain.schedule.service;

import com.intp.domain.schedule.dto.ScheduleMonthlyResponseDTO;

import java.util.List;

public interface ScheduleQueryService {

    public List<ScheduleMonthlyResponseDTO> getMonthlySchedules(Integer targetYear, Integer targetMonth );

}
