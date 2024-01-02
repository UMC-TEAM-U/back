package com.intp.domain.birthday.entity;


import com.intp.domain.user.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Birthday {

    @Id @GeneratedValue
    @Column(name="birthday_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="friend_id")
    private Friend friend;

    private int price; // user가 받은 선물의 가격

    private String memo;




}