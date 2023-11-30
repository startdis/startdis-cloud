package com.startdis.comm.core.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 权限范围枚举定义
 */
@Getter
@AllArgsConstructor
public enum PermissionScopeEnum {

    GROUP("group","集团范围"),
    COMPANY("company","公司范围");

    @JsonValue
    private String code;

    private String desc;

    @JsonCreator
    public static PermissionScopeEnum codeOf(String code) {
        return Arrays.stream(PermissionScopeEnum.values())
            .filter(each -> each.getCode().equals(code))
            .findFirst()
            .orElseThrow(() -> {
                throw new IllegalArgumentException("非法参数");
            });
    }
}
