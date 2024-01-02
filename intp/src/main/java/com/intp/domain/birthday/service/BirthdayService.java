package com.intp.domain.birthday.service;


import com.intp.domain.birthday.dto.BirthdayDTO;
import com.intp.domain.birthday.entity.Birthday;
import com.intp.domain.birthday.repository.BirthdayReopository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BirthdayService {

    private final BirthdayReopository birthdayReopository;

    public void save(BirthdayDTO birthdayDTO){
        //Birthday birthday = CreateFriendRequestDTO.toEntity(createFriendRequestDTO,member);
    }
}
