package com.intp.domain.changehistory.entity;

import com.intp.domain.friend.entity.Friend;
import com.intp.domain.user.entity.Member;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "change_history")
public class ChangeHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "change_history_id")
    private Long id;

    private String reason;

    private Integer before_change;
    private Integer after_change;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "friend_id")
    private Friend friend;

}
