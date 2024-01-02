package com.intp.domain.friend.dto;

import com.intp.domain.changehistory.entity.ChangeHistory;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ChangeHistoryResponseDTO {
    private LocalDateTime updatedAt;
    private String reason;
    private Integer before;
    private Integer after;

    public static ChangeHistoryResponseDTO from(ChangeHistory changeHistory) {
        return ChangeHistoryResponseDTO.builder()
                .updatedAt(changeHistory.getFriend().getModifiedAt())
                .reason(changeHistory.getReason())
                .before(changeHistory.getBefore_change())
                .after(changeHistory.getAfter_change())
                .build();
    }
}
