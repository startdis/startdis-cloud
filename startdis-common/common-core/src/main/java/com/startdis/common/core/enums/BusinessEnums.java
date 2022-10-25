package com.startdis.common.core.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

/**
 * @author Startdis
 * @email startdis@cloud-number.cn
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
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum BusinessEnums implements BusinessCode {
    
    /**
     * 面向外部传递的错误码共六位，并且有如下分类： 错误类型，表示错误来源，1位字母。 应用标识，表示错误属于哪个应用，2位数字。 错误编码，错误类型下的具体错误，3位数字。
     * <p>
     * 错误类型： A-表示错误来源于用户 B-表示错误来源于系统 C-表示错误来源于第三方接口
     */
    FEIGN_API_ERROR("C01501", "内部接口调用异常"),
    OTHER_API_ERROR("C01502", "三方接口调用异常"),
    
    /**
     * 自定义业务异常
     */
    BUSINESS_ERROR("B01500", "业务内部异常");
    
    private final String code;
    
    private final String msg;
    
    // 根据code返回msg信息
    public String getMsgByCode(String code) {
        for (BusinessEnums entry : BusinessEnums.values()) {
            if (Objects.equals(entry.getCode(), code)) {
                return entry.getMsg();
            }
        }
        
        return "";
    }
    
}

