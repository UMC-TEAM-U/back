package com.intp.domain.event.entity;

import com.intp.domain.friend.entity.Friend;
import com.intp.domain.user.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="event_id")
    private Long eventId;

    @Column(nullable = false)
    private String eventName;

    @Column(nullable = false)
    private int price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="friend_id", nullable = false)
    private Friend friend;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
}
