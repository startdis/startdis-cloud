package com.startdis.comm.exception.custom;

import com.startdis.comm.core.enums.CommonExceptionCode;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc BusinessException
 */
@Data
@NoArgsConstructor
public class BusinessException extends RuntimeException {

    private String code;
    private String message;

    @Getter
    @Setter
    private Object data;

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public BusinessException(String code, Throwable cause) {
        super(cause);
        this.code = code;
        this.message = cause.getMessage();
    }

    public BusinessException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.message = message;
    }

    public BusinessException(CommonExceptionCode exceptionCode) {
        super(exceptionCode.getMsg());
        this.code = exceptionCode.getCode();
        this.message = exceptionCode.getMsg();
    }

    public BusinessException(String code, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
        this.message = message;
    }
}

