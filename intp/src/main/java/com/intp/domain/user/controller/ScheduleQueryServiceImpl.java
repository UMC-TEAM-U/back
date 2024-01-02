package com.intp.domain.user.controller;

import com.intp.domain.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScheduleQueryServiceImpl implements ScheduleQueryService{

    private final ScheduleRepository scheduleRepository;


}
