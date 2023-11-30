package com.startdis.sys.server.exception;

import com.startdis.comm.exception.custom.BusinessException;

public class SysServiceException extends BusinessException {

    public SysServiceException(String code, String message) {
        super(code, message);
    }

    public SysServiceException(String code, Throwable cause) {
        super(code, cause);
    }

    public SysServiceException(String code, String message, Throwable cause) {
        super(code, message, cause);
    }

    public SysServiceException(String code, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(code, message, cause, enableSuppression, writableStackTrace);
    }
}
