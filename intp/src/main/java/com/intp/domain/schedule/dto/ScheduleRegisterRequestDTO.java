package com.intp.domain.schedule.dto;

import com.intp.domain.friend.entity.Friend;
import com.intp.domain.schedule.entity.Schedule;
import com.intp.domain.user.entity.Member;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

@Getter
@Builder
@Data
public class ScheduleRegisterRequestDTO {

    @NotNull
    private LocalDateTime date;
    @NotNull
    private String memo;
    @NotNull
    private String title;
    @NotNull
    private Long friendId;

    public static Schedule toEntity(ScheduleRegisterRequestDTO scheduleRegisterRequestDTO,
                                    Friend friend) {

        return Schedule.builder()
                .date(scheduleRegisterRequestDTO.date)
                .memo(scheduleRegisterRequestDTO.memo)
                .title(scheduleRegisterRequestDTO.title)
                .friend(friend)
                .build();

    }
}
