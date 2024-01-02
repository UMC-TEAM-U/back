package com.intp.domain.birthday.dto;

import com.intp.domain.birthday.entity.Birthday;
import com.intp.domain.friend.dto.FriendResponseDTO;
import com.intp.domain.friend.entity.Friend;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class BirthdayResponseDTO {

    private int price;
    private String presentName;

    public static BirthdayResponseDTO from(Birthday birthday) {
        return BirthdayResponseDTO.builder()
                .price(birthday.getPrice())
                .presentName(birthday.getPresentName())
                .build();
    }

}