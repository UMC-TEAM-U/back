package com.intp.domain.schedule.controller;

import com.intp.common.response.ApiResponse;
import com.intp.common.response.status.ErrorStatus;
import com.intp.domain.schedule.dto.ScheduleRegisterRequestDTO;
import com.intp.domain.schedule.service.ScheduleCommandService;
import com.intp.domain.schedule.service.ScheduleQueryService;
import com.intp.domain.user.dto.UserSignUpRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.intp.common.util.ValidationUtils.getValidationErrors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/schedule")
public class ScheduleRegisterController {

    private final ScheduleCommandService scheduleCommandService;


    // 일정 추가하기
    @PostMapping("/register")
    public ApiResponse createSchedule(@RequestBody @Valid ScheduleRegisterRequestDTO scheduleRegisterRequestDTO, Errors errors) {
        if (errors.hasErrors()) {
            return ApiResponse.ofFailure(ErrorStatus.SCHEDULE_POST_ARGUMENT_ERROR, getValidationErrors(errors));
        }
        return ApiResponse.onSuccess(scheduleCommandService.registerSchedule(scheduleRegisterRequestDTO));
    }

}