package com.intp.domain.schedule.dto;

import com.intp.domain.schedule.entity.Schedule;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Getter
public class ScheduleMonthlyResponseDTO {

    @NotNull
    private Long scheduleId;

    @NotNull
    private LocalDateTime date;

    @NotNull
    private String title;

    public static ScheduleMonthlyResponseDTO from(Schedule schedule) {
        return ScheduleMonthlyResponseDTO.builder()
                .date(schedule.getDate())
                .scheduleId(schedule.getId())
                .title(schedule.getTitle())
                .build();
    }

    public static List<ScheduleMonthlyResponseDTO> convertToDTOList(List<Schedule> schedules) {
        return schedules.stream()
                .map(ScheduleMonthlyResponseDTO::from)
                .collect(Collectors.toList());
    }
}
