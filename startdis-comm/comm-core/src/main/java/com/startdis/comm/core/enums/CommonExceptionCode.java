package com.startdis.comm.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 错误码设计描述
 * <p>
 * 面向日志的错误码定义共十三位（十位有意义，三位连接符），并且应该具有如下分类： 应用标识，表示错误属于哪个应用，三位数字。 功能域标识，表示错误属于应用中的哪个功能模块，三位数字。 错误类型，表示错误属于那种类型，一位字母。
 * 错误编码，错误类型下的具体错误，三位数字。
 * <p>
 * 面向外部传递的错误码共六位，并且有如下分类： 错误类型，表示错误来源，1位字母。 应用标识，表示错误属于哪个应用，2位数字。 错误编码，错误类型下的具体错误，3位数字。
 * <p>
 * 错误类型： A-表示错误来源于用户 B-表示错误来源于系统 C-表示错误来源于第三方接口
 */
@Getter
@AllArgsConstructor
public enum CommonExceptionCode implements ExceptionCode {

    /**
     * 面向外部传递的错误码共六位，并且有如下分类： 错误类型，表示错误来源，1位字母。 应用标识，表示错误属于哪个应用，2位数字。 错误编码，错误类型下的具体错误，3位数字。
     * <p>
     * 错误类型： A-表示错误来源于用户 B-表示错误来源于系统 C-表示错误来源于第三方接口
     */
    /****************************客户端异常****************************/
    ILLEGAL_ARGUMENT("A01001", "非法参数"),
    NOT_LOGGED_IN("A01002", "未登录"),
    /****************************系统异常****************************/
    SYSTEM_ERROR("B01001", "系统异常"),
    BUSINESS_ERROR("B01002", "业务异常"),
    ILLEGAL_PARAM("B01003", "非法入参"),
    ILLEGAL_OPERATION("B01004", "非法操作"),
    USER_INFO_IS_NULL("B01005", "信息不能为空"),
    EXTERNAL_API_ERROR("B01006", "调用接口异常"),
    SEND_MQ_ERROR("B02007", "发送mq异常"),
    /****************************三方异常****************************/
    OTHER_API_ERROR("C01502", "三方接口调用异常"),


    ;

    private String code;

    private String msg;

}
