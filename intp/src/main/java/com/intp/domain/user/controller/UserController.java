package com.intp.domain.user.controller;

import com.intp.common.jwt.JwtTokenProvider;
import com.intp.common.response.status.ErrorStatus;
import com.intp.domain.user.dto.UserLoginRequestDTO;
import com.intp.domain.user.dto.UserSignUpRequestDto;
import com.intp.domain.user.service.UserService;
import com.intp.common.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/users")
@RestController
public class UserController {

    private final JwtTokenProvider jwtTokenProvider;
    private final UserService usersService;

    @CrossOrigin
    @PostMapping("/sign-up")
    public ApiResponse signUp(@Valid @RequestBody  UserSignUpRequestDto userSignUpRequestDto,
                              Errors errors) {
        if (errors.hasErrors()) {
            return ApiResponse.ofFailure(ErrorStatus.MEMBER_SIGNUP_ERROR, getValidationErrorList(errors));
        }
        return usersService.signUp(userSignUpRequestDto);
    }

    @CrossOrigin
    @PostMapping("/login")
    public ApiResponse login(@Validated @RequestBody UserLoginRequestDTO userLoginRequestDTO,
                             Errors errors) {
        if (errors.hasErrors()) {
            return ApiResponse.ofFailure(ErrorStatus.MEMBER_SIGNUP_ERROR, getValidationErrorList(errors));
        }
        return usersService.login(userLoginRequestDTO);
    }


    private Map<String, String> getValidationErrors(Errors errors) {
        return errors.getAllErrors().stream()
                .collect(Collectors.toMap(
                        error -> ((FieldError) error).getField(),
                        error -> error.getDefaultMessage()
                ));
    }
    private List<String> getValidationErrorList(Errors errors) {
        return errors.getAllErrors().stream()
                .map(error -> error.getDefaultMessage())
                .collect(Collectors.toList());
    }



}
