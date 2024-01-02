package com.intp.domain.birthday.controller;


import com.intp.common.response.ApiResponse;
import com.intp.common.response.status.ErrorStatus;
import com.intp.domain.birthday.dto.BirthdayDTO;
import com.intp.domain.birthday.service.BirthdayService;
import com.intp.domain.friend.dto.CreateFriendRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.intp.common.util.ValidationUtils.getValidationErrors;

@RestController
@RequiredArgsConstructor
public class BirthdayController {

    private final BirthdayService birthdayService;

    @PostMapping("/birthday/addpresent")
    public ApiResponse createFriend(@Valid @RequestBody BirthdayDTO birthdayDTO,
                                    Errors errors) {
        if (errors.hasErrors()) {
            return ApiResponse.ofFailure(ErrorStatus.PRESENT_ERROR, getValidationErrors(errors));
        }
        return birthdayService.save(birthdayDTO);

    }
}
