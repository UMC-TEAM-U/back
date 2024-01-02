package com.intp.common.exception.handler;

import com.intp.common.exception.GeneralException;
import com.intp.common.response.BaseErrorCode;

public class UserHandler extends GeneralException {
    public UserHandler(BaseErrorCode code) {
        super(code);
    }
}
