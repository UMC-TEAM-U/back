package com.intp.domain.birthday.controller;


import com.intp.common.response.ApiResponse;
import com.intp.common.response.status.ErrorStatus;
import com.intp.domain.birthday.dto.CreateBirthdayRequestDTO;
import com.intp.domain.birthday.service.BirthdayService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.intp.common.util.ValidationUtils.getValidationErrors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/birthdays")
public class BirthdayController {

    private final BirthdayService birthdayService;

    @PostMapping("/")
    public ApiResponse createFriend(@Valid @RequestBody CreateBirthdayRequestDTO birthdayDTO,
                                    Errors errors) {
        if (errors.hasErrors()) {
            return ApiResponse.ofFailure(ErrorStatus.PRESENT_ERROR, getValidationErrors(errors));
        }
        return birthdayService.createBirthday(birthdayDTO);

    }

    @GetMapping("/")
    public List<BirthdayResponseDTO> getBirthday() {
        return birthdayService.getBirthdays();
    }

}
