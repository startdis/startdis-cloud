package com.startdis.common.core.enums;


/**
 * @author Startdis
 * @email startdis@cloud-number.cn
 * @desc 异常code接口
 */
public interface BusinessCode {
    
    /**
     * 异常code
     */
    String getCode();
    
    /**
     * 异常消息
     */
    String getMsg();
}
