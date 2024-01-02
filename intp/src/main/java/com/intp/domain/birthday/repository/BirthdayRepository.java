package com.intp.domain.birthday.repository;

import com.intp.domain.birthday.entity.Birthday;
import com.intp.domain.user.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BirthdayRepository extends JpaRepository<Birthday,Long> {

    Optional<Birthday> findByfriendId(Long id);
    List<Birthday> findAllByMember(Member member);

}
