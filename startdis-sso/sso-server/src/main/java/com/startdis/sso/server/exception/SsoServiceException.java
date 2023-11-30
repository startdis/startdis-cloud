package com.startdis.sso.server.exception;

import com.startdis.comm.exception.custom.BusinessException;

public class SsoServiceException extends BusinessException {

    public SsoServiceException(String code, String message) {
        super(code, message);
    }

    public SsoServiceException(String code, Throwable cause) {
        super(code, cause);
    }

    public SsoServiceException(String code, String message, Throwable cause) {
        super(code, message, cause);
    }

    public SsoServiceException(String code, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(code, message, cause, enableSuppression, writableStackTrace);
    }
}
