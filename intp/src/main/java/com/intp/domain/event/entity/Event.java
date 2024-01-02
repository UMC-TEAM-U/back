package com.intp.domain.event.entity;

import com.intp.domain.friend.entity.Friend;
import com.intp.domain.user.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="event_id")
    private LocalDateTime event_id;

    @Column(nullable = false)
    private String event_content;

    @Column(nullable = false)
    private int price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="friend_id", nullable = false)
    private Friend friend;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;
}
