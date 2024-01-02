package com.intp.domain.schedule.service;

import com.intp.common.exception.handler.ScheduleHandler;
import com.intp.common.response.status.ErrorStatus;
import com.intp.domain.schedule.dto.ScheduleMonthlyResponseDTO;
import com.intp.domain.schedule.entity.Schedule;
import com.intp.domain.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ScheduleQueryServiceImpl implements ScheduleQueryService{


    private final ScheduleRepository scheduleRepository;

    public List<ScheduleMonthlyResponseDTO> getMonthlySchedules(Integer targetYear, Integer targetMonth ) {

        if (targetMonth < 1 || targetMonth > 12) {

            throw new ScheduleHandler(ErrorStatus.SCHEDULE_MONTHLY_ARGUMENT_ERROR);
        }

        List<Schedule> monthlySchedules = scheduleRepository.findAll()
                .stream()
                .filter(schedule -> schedule.getDate().getMonthValue() == targetMonth
                        && schedule.getDate().getYear() == targetYear)
                .limit(3)
                .collect(Collectors.toList());

        return ScheduleMonthlyResponseDTO.convertToDTOList(monthlySchedules);
    }

}
