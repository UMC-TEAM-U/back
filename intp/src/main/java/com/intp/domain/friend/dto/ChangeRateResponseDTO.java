package com.intp.domain.friend.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ChangeRateResponseDTO {
    private LocalDateTime updatedAt;
    private String reason;
}
