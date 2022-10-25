package com.startdis.common.exception.custom;

import com.startdis.common.core.enums.BusinessEnums;
import com.startdis.common.domain.bean.ResultBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

/**
 * @author Startdis
 * @email startdis@cloud-number.cn
 * @desc GlobalExceptionHandler
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(value = BusinessException.class)
    public ResultBean BusinessExceptionHandler(BusinessException e) {
        ResultBean res = ResultBean.builder().build();
        res.setCode(e.getCode());
        res.setMsg(e.getMessage());
        log.error(String.valueOf(res));
        return res;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = SystemException.class)
    public ResultBean SystemExceptionHandler(SystemException e) {
        ResultBean res = ResultBean.builder().build();
        res.setCode(e.getCode());
        res.setMsg(e.getCode());
        log.error(String.valueOf(res));
        return res;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResultBean handleMaxUploadSizeExceededException(MaxUploadSizeExceededException e){
        ResultBean res = ResultBean.builder().build();
        res.setCode("B01001");
        res.setMsg("Upload file too large.");
        log.error("Upload file too large.");
        return res;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(Exception.class)
    public ResultBean ExceptionHandler(Exception e) {
        ResultBean res = ResultBean.builder().build();
        res.setCode(BusinessEnums.BUSINESS_ERROR.getCode());
        res.setMsg(BusinessEnums.BUSINESS_ERROR.getMsg());
        log.error(e.getMessage());
        return res;
    }
}

