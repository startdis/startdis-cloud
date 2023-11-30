package com.startdis.comm.core.enums;

import com.startdis.comm.core.constant.FormNoConstants;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 单号生成类型枚举
 * <p>
 * 注：随机号位于流水号之后,流水号使用redis计数据，每天都是一个新的key,长度不足时则自动补0
 * <p>
 * 生成规则 =固定前缀+当天日期串+流水号(redis自增，不足长度则补0)+随机数
 */
@Getter
@AllArgsConstructor
public enum FormNoTypeEnum {

    /**
     * 固定前缀：SH
     * 时间格式：yyyyMMdd
     * 流水号长度：7(当单日单据较多时可根据业务适当增加流)
     * 随机数长度：4
     * 总长度：13
     */
    FORM_NO("D", FormNoConstants.SERIAL_YYYYMMDD_PREFIX, 4, 1, 13);

    /**
     * 单号前缀
     * 为空时填""
     */
    private String prefix;

    /**
     * 时间格式表达式
     * 例如：yyyyMMdd
     */
    private String datePattern;

    /**
     * 流水号长度
     */
    private Integer serialLength;
    /**
     * 随机数长度
     */
    private Integer randomLength;

    /**
     * 总长度
     */
    private Integer totalLength;
}