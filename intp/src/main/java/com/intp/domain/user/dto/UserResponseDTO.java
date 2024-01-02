package com.intp.domain.user.dto;


import com.intp.common.jwt.TokenInfo;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserResponseDTO {

    TokenInfo tokenInfo;
    String nickName;
}
