package com.intp.domain.friend.repository;

import com.intp.domain.friend.entity.Friend;
import com.intp.domain.user.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendRepository extends JpaRepository<Friend,Long> {
    List<Friend> findAllByMember(Member member);
}
