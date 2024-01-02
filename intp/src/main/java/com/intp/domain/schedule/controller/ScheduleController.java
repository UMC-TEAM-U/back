package com.intp.domain.schedule.controller;

import com.intp.common.response.ApiResponse;
import com.intp.common.response.status.ErrorStatus;
import com.intp.domain.schedule.dto.ScheduleRegisterRequestDTO;
import com.intp.domain.schedule.service.ScheduleCommandService;
import com.intp.domain.schedule.service.ScheduleQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.intp.common.util.ValidationUtils.getValidationErrors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/schedules")
public class ScheduleController {

    private final ScheduleCommandService scheduleCommandService;
    private final ScheduleQueryService scheduleQueryService;


    // 일정 추가하기
    @PostMapping("/")
    public ApiResponse createSchedule(@RequestBody @Valid ScheduleRegisterRequestDTO scheduleRegisterRequestDTO, Errors errors) {
        if (errors.hasErrors()) {
            return ApiResponse.ofFailure(ErrorStatus.SCHEDULE_POST_ARGUMENT_ERROR, getValidationErrors(errors));
        }
        return ApiResponse.onSuccess(scheduleCommandService.registerSchedule(scheduleRegisterRequestDTO));
    }

    @GetMapping("/")
    public ApiResponse getMonthlySchedule(@RequestParam Integer year,
                                          @RequestParam Integer month) {
//        if (errors.hasErrors()) {
//            return ApiResponse.ofFailure(ErrorStatus.SCHEDULE_POST_ARGUMENT_ERROR, getValidationErrors(errors));
//        }
        return ApiResponse.onSuccess(scheduleQueryService.getMonthlySchedules(year, month));
    }



}