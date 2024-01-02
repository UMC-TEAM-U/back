package com.intp.domain.birthday.entity;


import com.intp.domain.friend.entity.Friend;
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

    private int price;

    private String memo;

    private String presentName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "friend_id")
    private Friend friend;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
}
