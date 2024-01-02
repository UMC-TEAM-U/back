package com.intp.domain.birthday.dto;


import com.intp.domain.birthday.entity.Birthday;
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

    private Long friend_id;

    //public static Birthday toEntity( BirthdayDTO birthdayDTO, Member member){
    //    return Birthday.builder();
    //}
}
