package com.intp.domain.birthday.dto;


import com.intp.domain.birthday.entity.Birthday;
import com.intp.domain.friend.entity.Friend;
import com.intp.domain.user.entity.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

@Builder
@Getter
@Setter
public class CreateBirthdayRequestDTO {

    @Range(min = 0, message = "0이상이여야합니다.")
    private int price;

    @NotNull
    private String memo;

    @NotNull
    private String presentName;

    @NotNull
    private Long friend_id;

    public static Birthday toEntity(CreateBirthdayRequestDTO birthdayDTO, Friend friend, Member member){
        return Birthday.builder()
                .price(birthdayDTO.getPrice())
                .memo(birthdayDTO.getMemo())
                .presentName(birthdayDTO.getPresentName())
                .friend(friend)
                .member(member)
                .build();

    }
}
