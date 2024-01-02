package com.intp.domain.schedule.service;

import com.intp.common.exception.handler.ScheduleHandler;
import com.intp.common.response.status.ErrorStatus;
import com.intp.domain.schedule.dto.ScheduleMonthlyResponseDTO;
import com.intp.domain.schedule.entity.Schedule;
import com.intp.domain.schedule.repository.ScheduleRepository;
import com.intp.domain.user.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class ScheduleQueryServiceImpl implements ScheduleQueryService{


    private final ScheduleRepository scheduleRepository;

    //월별 조회 api입니다.
    public List<ScheduleMonthlyResponseDTO> getMonthlySchedules(Integer targetYear, Integer targetMonth ) {

        if (targetMonth < 1 || targetMonth > 12) {

            throw new ScheduleHandler(ErrorStatus.SCHEDULE_MONTHLY_ARGUMENT_ERROR);
        }

        List<Schedule> monthlySchedules = scheduleRepository.findAll()
                .stream()
                .filter(schedule -> schedule.getDate().getMonthValue() == targetMonth
                        && schedule.getDate().getYear() == targetYear)
                .collect(Collectors.groupingBy(schedule -> schedule.getDate()))
                .values()
                .stream()
                .flatMap(sameDateSchedules -> sameDateSchedules.stream().limit(3))
                .collect(Collectors.toList());

        return ScheduleMonthlyResponseDTO.convertToDTOList(monthlySchedules);
    }

    // 일별 조회 api입니다.
    public List<ScheduleMonthlyResponseDTO> getDateSchedules(Integer targetYear, Integer targetMonth, Integer targetDate){
        if (targetMonth < 1 || targetMonth > 12 || targetDate < 1 || targetDate > 31) {
            throw new ScheduleHandler(ErrorStatus.SCHEDULE_DATE_ARGUMENT_ERROR);
        }

        List<Schedule> monthlySchedules = scheduleRepository.findAll()
                .stream()
                .filter(schedule -> schedule.getDate().getMonthValue() == targetMonth
                        && schedule.getDate().getYear() == targetYear
                        && schedule.getDate().getDayOfMonth() == targetDate)
        .collect(Collectors.toList());

        return ScheduleMonthlyResponseDTO.convertToDTOList(monthlySchedules);
    }

    public Boolean deleteSchedule(Long scheduleId){

        try {
            scheduleRepository.deleteById(scheduleId);
            return true;
        } catch (EmptyResultDataAccessException e) {
            throw new ScheduleHandler(ErrorStatus.SCHEDULE_DELETE_NOT_EXIST_ERROR);
        }

    }


}