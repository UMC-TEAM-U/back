package com.intp.domain.changehistory.repository;

import com.intp.domain.changehistory.entity.ChangeHistory;
import com.intp.domain.friend.entity.Friend;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChangeHistoryRepository extends JpaRepository<ChangeHistory,Long> {
    List<ChangeHistory> findAllByFriend(Friend friend);
}
