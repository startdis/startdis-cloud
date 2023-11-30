package com.startdis.comm.core.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum WosTypeConfigEnum {
    PRODUCT("0","产品类型"),

    FAULT("1","故障类型"),

    LEARN_MATERIALS("2","资料类别"),;

    @JsonValue
    private String code;

    private String desc;
}
