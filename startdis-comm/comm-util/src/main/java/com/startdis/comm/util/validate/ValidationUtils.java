package com.startdis.comm.util.validate;

import cn.hutool.core.collection.CollUtil;
import com.startdis.comm.core.enums.CommonExceptionCode;
import com.startdis.comm.exception.custom.BusinessException;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc 主动校验工具类
 */
public class ValidationUtils {

    private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    /**
     * validate主动校验方式
     *
     * @param obj 进行校验的对象
     * @param <T> 传递的校验类型
     */
    public static <T> void validate(T obj) {
        Set<ConstraintViolation<T>> validateSet = validator
            .validate(obj);
        if (CollUtil.isNotEmpty(validateSet)) {
            String messages = validateSet.stream()
                .map(ConstraintViolation::getMessage)
                .reduce((m1, m2) -> m1 + ";" + m2)
                .orElse("parameter error！" + obj);
            throw new BusinessException(CommonExceptionCode.ILLEGAL_PARAM.getCode(), messages);
        }
    }

}
