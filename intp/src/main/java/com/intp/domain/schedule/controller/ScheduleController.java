package com.intp.domain.schedule.controller;

import com.intp.common.response.ApiResponse;
import com.intp.common.response.status.ErrorStatus;
import com.intp.domain.schedule.dto.ScheduleRegisterRequestDTO;
import com.intp.domain.schedule.service.ScheduleCommandService;
import com.intp.domain.schedule.service.ScheduleQueryService;
import io.swagger.v3.oas.annotations.Operation;
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
    @CrossOrigin
    @Operation(summary = "일정 생성 API")
    @PostMapping("")
    public ApiResponse createSchedule(@RequestBody @Valid ScheduleRegisterRequestDTO scheduleRegisterRequestDTO, Errors errors) {
        if (errors.hasErrors()) {
            return ApiResponse.ofFailure(ErrorStatus.SCHEDULE_POST_ARGUMENT_ERROR, getValidationErrors(errors));
        }
        return ApiResponse.onSuccess(scheduleCommandService.registerSchedule(scheduleRegisterRequestDTO));
    }

    @CrossOrigin
    @Operation(summary = "월별 일정 조회 API")
    @GetMapping("")
    public ApiResponse getMonthlySchedules(@RequestParam Integer year,
                                           @RequestParam Integer month) {

        return ApiResponse.onSuccess(scheduleQueryService.getMonthlySchedules(year, month));
    }

    @CrossOrigin
    @Operation(summary = "일별 일정 조회 API")
    @GetMapping("/detail")
    public ApiResponse getDateSchedules(@RequestParam Integer year,
                                          @RequestParam Integer month,
                                          @RequestParam Integer date
    ) {

        return ApiResponse.onSuccess(scheduleQueryService.getDateSchedules(year, month, date));
    }

    @CrossOrigin
    @DeleteMapping("/{schedule_id}")
    @Operation(summary = "일정 삭제 API")
    public ApiResponse getDateSchedules(@PathVariable Long schedule_id
    ) {
        return ApiResponse.onSuccess(scheduleQueryService.deleteSchedule(schedule_id));
    }

}
