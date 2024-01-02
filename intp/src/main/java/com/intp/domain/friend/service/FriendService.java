package com.intp.domain.friend.service;

import com.intp.common.exception.handler.ScheduleHandler;
import com.intp.common.exception.handler.UserHandler;
import com.intp.common.jwt.SecurityUtil;
import com.intp.common.response.status.ErrorStatus;
import com.intp.domain.birthday.entity.Birthday;
import com.intp.domain.birthday.repository.BirthdayRepository;
import com.intp.domain.changehistory.entity.ChangeHistory;
import com.intp.domain.changehistory.repository.ChangeHistoryRepository;
import com.intp.domain.event.entity.Event;
import com.intp.domain.event.repository.EventRepository;
import com.intp.domain.friend.dto.*;
import com.intp.domain.friend.entity.Friend;
import com.intp.domain.friend.entity.FriendLevel;
import com.intp.domain.friend.repository.FriendRepository;
import com.intp.domain.user.entity.Member;
import com.intp.domain.user.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FriendService {
    private final MemberRepository memberRepository;
    private final EventRepository eventRepository;
    private final BirthdayRepository birthdayRepository;
    private final FriendRepository friendRepository;
    private final ChangeHistoryRepository changeHistoryRepository;

    public CreateFriendResponseDTO createFriend(CreateFriendRequestDTO createFriendRequestDTO) {
        Member member = getMemberFromToken();
        Friend friend = CreateFriendRequestDTO.toEntity(createFriendRequestDTO, member);
        friendRepository.save(friend);
        return CreateFriendResponseDTO.from(friend);
    }

    public List<FriendResponseDTO> getFriends(int sort) {
        Member member = getMemberFromToken();
        List<Friend> friends;
        if (sort == 0) {
            friends = friendRepository.findAllByMember(member);
        } else {
            friends = friendRepository.findAllByMemberAndFriendLevel(member, FriendLevel.fromLevel(sort));
        }
        return friends.stream()
                .map(FriendResponseDTO::from)
                .collect(Collectors.toList());
    }

    public FriendResponseDTO getFriend(Long friendId) {
        Friend friend = friendRepository.findById(friendId).orElseThrow(() -> new ScheduleHandler(ErrorStatus.SCHEDULE_POST_ARGUMENT_ERROR));
        return FriendResponseDTO.from(friend);
    }

    public List<ChangeHistoryResponseDTO> getChanges(Long friendId){
        Friend friend = friendRepository.findById(friendId).orElseThrow(() -> new ScheduleHandler(ErrorStatus.SCHEDULE_POST_ARGUMENT_ERROR));
        List<ChangeHistory> changeHistories = changeHistoryRepository.findAllByFriend(friend);
        return changeHistories.stream()
                .map(ChangeHistoryResponseDTO::from)
                .collect(Collectors.toList());
    }

    public FriendResponseDTO changeFriendRate(UpdateFriendRequestDTO updateFriendRequestDTO) {
        Friend friend = friendRepository.findById(updateFriendRequestDTO.getFriendId()).orElseThrow(() -> new ScheduleHandler(ErrorStatus.SCHEDULE_POST_ARGUMENT_ERROR));
        ChangeHistory changeHistory
                = ChangeHistory
                .builder()
                .before_change(friend.getFriendLevel().getLevel())
                .after_change(updateFriendRequestDTO.getLevel())
                .reason(updateFriendRequestDTO.getReason())
                .friend(friend)
                .build();
        friend.setFriendLevel(FriendLevel.fromLevel(updateFriendRequestDTO.getLevel()));
        changeHistoryRepository.save(changeHistory);
        return FriendResponseDTO.from(friend);
    }

    public List<FriendResponseDTO> getBirthdayFriends(){
        List<Birthday> birthdayList = birthdayRepository.findAllByMember(getMemberFromToken());
        System.out.println(birthdayList.size());
        List<Friend> friendList = birthdayList.stream()
                .map(Birthday::getFriend)
                .distinct() // optional, removes duplicates
                .collect(Collectors.toList());
        return friendList.stream()
                .map(FriendResponseDTO::from)
                .collect(Collectors.toList());
    }

    public List<FriendResponseDTO> getEventFriends(){
        List<Event> eventList = eventRepository.findAllByMember(getMemberFromToken());
        System.out.println(eventList.size());
        List<Friend> friendList = eventList.stream()
                .map(Event::getFriend)
                .distinct() // optional, removes duplicates
                .collect(Collectors.toList());
        return friendList.stream()
                .map(FriendResponseDTO::from)
                .collect(Collectors.toList());
    }


    private Member getMemberFromToken() {
        String userEmail = SecurityUtil.getCurrentUserEmail();
        Member member = memberRepository.findByEmail(userEmail)
                .orElseThrow(() -> new UserHandler(ErrorStatus._UNAUTHORIZED));
        return member;
    }
}
