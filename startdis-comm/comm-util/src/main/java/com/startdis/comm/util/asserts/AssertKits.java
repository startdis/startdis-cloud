package com.startdis.comm.util.asserts;

import com.startdis.comm.core.enums.CommonExceptionCode;
import com.startdis.comm.core.enums.ExceptionCode;
import com.startdis.comm.exception.custom.BusinessException;

/**
 * @author Startdis
 * @email startdis@dianjiu.cc
 * @desc AssertKits
 */
public class AssertKits {
    /**
     * 检查表达式是否为true,true忽略,false抛出异常
     *
     * @param expression 表达式
     * @param message    异常消息
     * @return void
     * @author Startdis
     * @date 2021/11/04 15:45
     */
    public static void check(boolean expression, String message) {
        if (!expression) {
            throw new BusinessException(CommonExceptionCode.ILLEGAL_PARAM.getCode(), message);
        }
    }

    /**
     * 检查表达式是否为true,true忽略,false抛出指定异常枚举
     *
     * @param expression 表达式
     * @param exception  指定异常枚举
     * @return void
     * @author Startdis
     * @date 2021/11/04 15:46
     */
    public static void check(boolean expression, ExceptionCode exception) {
        if (!expression) {
            throw new BusinessException(exception.getCode(), exception.getMsg());
        }
    }

    /**
     * 检查表达式是否为true,true忽略,false抛出指定异常枚举
     *
     * @param expression 表达式
     * @param exception  指定异常枚举
     * @param message 错误描述
     * @return void
     * @author Startdis
     * @date 2021/11/04 15:46
     */
    public static void check(boolean expression, ExceptionCode exception, String message) {
        if (!expression) {
            if (message.isEmpty()) {
                throw new BusinessException(exception.getCode(), exception.getMsg());
            }
            throw new BusinessException(exception.getCode(), message);
        }
    }

    /**
     * 检查表达式是否为true,true忽略,false抛出异常
     *
     * @param expression 表达式
     * @param message    异常消息
     * @return void
     * @author Startdis
     * @date 2021/11/04 15:45
     */
    public static void checkIsFalse(boolean expression, String message) {
        if (expression) {
            throw new BusinessException(CommonExceptionCode.ILLEGAL_PARAM.getCode(), message);
        }
    }

    /**
     * 检查表达式是否为true,true忽略,false抛出指定异常枚举
     *
     * @param expression 表达式
     * @param exception  指定异常枚举
     * @return void
     * @author Startdis
     * @date 2021/11/04 15:46
     */
    public static void checkIsFalse(boolean expression, ExceptionCode exception) {
        if (expression) {
            throw new BusinessException(exception.getCode(), exception.getMsg());
        }
    }

    /**
     * 检查表达式是否为true,true忽略,false抛出指定异常枚举
     *
     * @param expression 表达式
     * @param exception  指定异常枚举
     * @param message 错误描述
     * @return void
     * @author Startdis
     * @date 2021/11/04 15:46
     */
    public static void checkIsFalse(boolean expression, ExceptionCode exception, String message) {
        if (expression) {
            if (message.isEmpty()) {
                throw new BusinessException(exception.getCode(), exception.getMsg());
            }
            throw new BusinessException(exception.getCode(), message);
        }
    }

    /**
     * 检查对象是否不为空,为空抛出异常
     *
     * @param object
     * @param message
     * @return void
     * @author Startdis
     * @date 2021/11/04 15:57
     */
    public static void notNull(Object object, String message) {
        if (object == null) {
            throw new BusinessException(CommonExceptionCode.ILLEGAL_PARAM.getCode(), message);
        }
    }

    /**
     * 检查对象是否不为空,为空抛出指定的异常枚举
     *
     * @param object
     * @param exception
     * @return void
     * @author Startdis
     * @date 2021/11/04 15:58
     */
    public static void notNull(Object object, ExceptionCode exception) {
        if (object == null) {
            throw new BusinessException(exception.getCode(), exception.getMsg());
        }
    }

    /**
     * 检查对象是否为空,不为空抛出指定的异常枚举
     *
     * @param object
     * @param message
     * @return void
     * @author Startdis
     * @date 2021/11/04 15:58
     */
    public static void isNull(Object object, String message) {
        if (object != null) {
            throw new BusinessException(CommonExceptionCode.ILLEGAL_PARAM.getCode(), message);
        }
    }

    /**
     * 检查对象是否为空,不为空抛出指定的异常枚举
     *
     * @param object
     * @param exception
     * @return void
     * @author Startdis
     * @date 2021/11/04 15:58
     */
    public static void isNull(Object object, ExceptionCode exception) {
        if (object != null) {
            throw new BusinessException(exception.getCode(), exception.getMsg());
        }
    }

    /**
     * 检查表达式是否为true,true忽略,false抛出指定异常枚举
     *
     * @param object 判断对象
     * @param exception  指定异常枚举
     * @param message 错误描述
     * @return void
     * @author Startdis
     * @date 2021/11/04 15:46
     */
    public static void isNull(Object object, ExceptionCode exception, String message) {
        if (object != null) {
            if (message.isEmpty()) {
                throw new BusinessException(exception.getCode(), exception.getMsg());
            }
            throw new BusinessException(exception.getCode(), message);
        }
    }

}
