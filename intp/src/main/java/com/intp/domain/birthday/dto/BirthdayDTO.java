package com.intp.domain.birthday.dto;


import com.intp.domain.birthday.entity.Birthday;
import com.intp.domain.friend.entity.Friend;
import com.intp.domain.user.entity.Member;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class BirthdayDTO {

    private int price;

    private String memo;

    private String presentName;

    private Long friend_id;

    public static Birthday toEntity( BirthdayDTO birthdayDTO, Friend friend){
        return Birthday.builder()
                .price(birthdayDTO.getPrice())
                .memo(birthdayDTO.getMemo())
                .presentName(birthdayDTO.getPresentName())
                .friend(friend)
                .build();

    }
}
