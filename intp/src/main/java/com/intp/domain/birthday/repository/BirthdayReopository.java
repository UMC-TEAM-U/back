package com.intp.domain.birthday.repository;

import com.intp.domain.birthday.entity.Birthday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BirthdayReopository extends JpaRepository<Birthday,Long> {

    Optional<Birthday> findByfriendId(Long id);

}
