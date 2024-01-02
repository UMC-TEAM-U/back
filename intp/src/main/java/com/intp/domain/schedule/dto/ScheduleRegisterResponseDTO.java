package com.intp.domain.schedule.dto;

import com.intp.domain.friend.entity.Friend;
import com.intp.domain.schedule.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Builder
@Getter
public class ScheduleRegisterResponseDTO {
    private LocalDateTime date;

    private String memo;

    private String title;

    private Long friendId;


        public static ScheduleRegisterResponseDTO from(Schedule schedule) {
            return ScheduleRegisterResponseDTO.builder()
                    .date(schedule.getDate())
                    .memo(schedule.getMemo())
                    .title(schedule.getTitle())
                    .build();
        }

}
