package com.intp.domain.schedule.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
//@RequestMapping("/members")
public class ScheduleRegisterController {
}


//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/members")
//public class MemberRestController {
//
//    private final MemberCommandService memberCommandService;
//
//    @PostMapping("/")
//    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request){
//        return null;
//    }
//}