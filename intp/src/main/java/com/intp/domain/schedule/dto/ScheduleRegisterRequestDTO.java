package com.intp.domain.schedule.dto;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

public class ScheduleRegisterRequestDTO {

    @Getter
    public static class RegisterRequestDTO{

        private LocalDateTime date;
        private String memo;
        private String title;
        private Long memberId;
        private Long friendId;

    }
}
