package com.intp.domain.friend.controller;

import com.intp.common.response.ApiResponse;
import com.intp.common.response.status.ErrorStatus;
import com.intp.common.response.status.SuccessStatus;
import com.intp.domain.friend.dto.CreateFriendRequestDTO;
import com.intp.domain.friend.dto.UpdateFriendRequestDTO;
import com.intp.domain.friend.service.FriendService;
import io.swagger.v3.oas.annotations.Operation;
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
    @CrossOrigin
    @Operation(summary = "친구 생성 API")
    @PostMapping
    public ApiResponse createFriend(@Valid @RequestBody CreateFriendRequestDTO createFriendRequestDTO,
                              Errors errors) {
        if (errors.hasErrors()) {
            return ApiResponse.ofFailure(ErrorStatus.FRIEND_ARGUMENT_ERROR, getValidationErrors(errors));
        }
        return ApiResponse.onSuccess(friendService.createFriend(createFriendRequestDTO));
    }
    @CrossOrigin
    @Operation(summary = "내 친구들 조회 API")
    @GetMapping
    public ApiResponse getFriends(@RequestParam int sort){
        return ApiResponse.onSuccess(friendService.getFriends(sort));
    }

    @CrossOrigin
    @Operation(summary = "특정 친구 조회 API")
    @GetMapping("/{friend_id}")
    public ApiResponse getFriend(@PathVariable("friend_id") Long friendId) {
        return ApiResponse.of(SuccessStatus._FRIEND_GET_SUCCESS, friendService.getFriend(friendId));
    }

    @CrossOrigin
    @Operation(summary = "친구 등급 변경 API")
    @PutMapping
    public ApiResponse changeFriendRate(@Valid @RequestBody UpdateFriendRequestDTO updateFriendRequestDTO, Errors errors) {
        if (errors.hasErrors()) {
            return ApiResponse.ofFailure(ErrorStatus.FRIEND_ARGUMENT_ERROR, getValidationErrors(errors));
        }
        return ApiResponse.of(SuccessStatus._FRIEND_GET_SUCCESS, friendService.changeFriendRate(updateFriendRequestDTO));
    }

    @CrossOrigin
    @Operation(summary = "친구 등급 변경 내역 조회 API")
    @GetMapping("/{friend_id}/changes")
    public ApiResponse getChangeFriendList(@PathVariable("friend_id") Long friendId) {
        return ApiResponse.of(SuccessStatus._FRIEND_AMEND_SUCCESS, friendService.getChanges(friendId));
    }

    @CrossOrigin
    @Operation(summary = "내 생일 축하해준 친구 조회 API")
    @GetMapping("/birthdays")
    public ApiResponse getBirthdayFriendList() {
        return ApiResponse.onSuccess(friendService.getBirthdayFriends());
    }

    @CrossOrigin
    @Operation(summary = "내 경조사 축화해준 친구 조회 API")
    @GetMapping("/events")
    public ApiResponse getEventFriendList() {
        return ApiResponse.onSuccess(friendService.getEventFriends());
    }
}
