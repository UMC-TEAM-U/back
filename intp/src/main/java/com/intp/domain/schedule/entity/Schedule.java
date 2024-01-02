package com.intp.domain.schedule.entity;

import com.intp.domain.user.entity.Member;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "Schedule")
public class Schedule {

    @Id @GeneratedValue
    @Column(name = "id")
    private Long id;

    private LocalDateTime date;

    private String memo;

    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "member_id")
    private Member member;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name= "friend_id")
//    private Friend friend;
}