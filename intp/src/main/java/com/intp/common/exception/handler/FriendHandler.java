package com.intp.common.exception.handler;

import com.intp.common.exception.GeneralException;
import com.intp.common.response.BaseErrorCode;

public class FriendHandler extends GeneralException {
    public FriendHandler(BaseErrorCode code) {
        super(code);
    }
}
