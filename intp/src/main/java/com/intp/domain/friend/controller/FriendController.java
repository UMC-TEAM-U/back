package com.intp.domain.friend.controller;

import com.intp.common.response.ApiResponse;
import com.intp.common.response.status.ErrorStatus;
import com.intp.domain.friend.dto.CreateFriendRequestDTO;
import com.intp.domain.friend.service.FriendService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.intp.common.util.ValidationUtils.getValidationErrors;

@RequiredArgsConstructor
@RequestMapping("/api/friends")
@RestController
public class FriendController {

    private final FriendService friendService;
    @PostMapping
    public ApiResponse createFriend(@Valid @RequestBody CreateFriendRequestDTO createFriendRequestDTO,
                              Errors errors) {
        if (errors.hasErrors()) {
            return ApiResponse.ofFailure(ErrorStatus.FRIEND_ARGUMENT_ERROR, getValidationErrors(errors));
        }
        return ApiResponse.onSuccess(friendService.createFriend(createFriendRequestDTO));
    }
}
