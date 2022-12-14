package com.startdis.common.exception.custom;

import lombok.Data;

/**
 * @author Startdis
 * @email startdis@cloud-number.cn
 * @desc BusinessException
 */
@Data
public class BusinessException extends RuntimeException {

    private String code;
    private String message;

    public BusinessException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
}

