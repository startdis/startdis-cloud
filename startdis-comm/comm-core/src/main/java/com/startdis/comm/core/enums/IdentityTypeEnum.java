package com.startdis.comm.core.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 身份类型枚举定义
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum IdentityTypeEnum {

    COMPANY("company", "集团公司账户"),
    //STARTDIS("startdis", "启迪官方账号"),
    VISITOR("visitor", "游客体验账号");

    private String code;

    private String desc;
}
