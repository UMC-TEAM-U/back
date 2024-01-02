package com.intp.common.exception.handler;

import com.intp.common.exception.GeneralException;
import com.intp.common.response.BaseErrorCode;

public class ScheduleHandler extends GeneralException {
    public ScheduleHandler(BaseErrorCode code){
        super(code);
    }
}

