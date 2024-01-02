package com.intp.domain.schedule.dto;

import com.intp.domain.friend.entity.Friend;
import com.intp.domain.schedule.entity.Schedule;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

@Getter
@Builder
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
                                    Friend friend,
                                    Member member
    ) {

        return Schedule.builder()
                .member(member)
                .date(scheduleRegisterRequestDTO.date)
                .memo(scheduleRegisterRequestDTO.memo)
                .title(scheduleRegisterRequestDTO.title)
                .friend(friend)
                .build();

    }
}
