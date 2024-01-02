package com.intp.domain.friend.entity;

import com.intp.common.entity.BaseTimeEntity;
import com.intp.domain.birthday.entity.Birthday;
import com.intp.domain.changehistory.entity.ChangeHistory;
import com.intp.domain.event.entity.Event;
import com.intp.domain.schedule.entity.Schedule;
import com.intp.domain.user.entity.Member;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

@Getter
@Setter
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PRIVATE)
@Builder
@Entity
@Table(name = "friend")
public class Friend extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "friend_id")
    private Long id;

    private String nickname;

    private String memo;

    private FriendLevel friendLevel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "friend", cascade = CascadeType.ALL)
    private List<ChangeHistory> changeHistoryList = new ArrayList<>();

    @OneToMany(mappedBy = "friend", cascade = CascadeType.ALL)
    private List<Birthday> birthdayList = new ArrayList<>();

    @OneToMany(mappedBy = "friend", cascade = CascadeType.ALL)
    private List<Event> eventList = new ArrayList<>();

    @OneToMany(mappedBy = "friend", cascade = CascadeType.ALL)
    private List<Schedule> scheduleList = new ArrayList<>();

}
