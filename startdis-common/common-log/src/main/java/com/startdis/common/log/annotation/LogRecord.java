package com.startdis.common.log.annotation;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import java.lang.annotation.*;

/**
 * @author DianJiu
 * @email dianjiusir@gmail.com
 * @date 2022-07-19
 * @desc 日志记录
 */
@Inherited
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Order(Ordered.HIGHEST_PRECEDENCE)
public @interface LogRecord {

    /**
     * 记录操作日志的修改详情
     *
     * @return
     */
    String detail() default "";

    /**
     * 操作日志的执行人
     *
     * @return
     */
    String operator() default "";

    /**
     * 操作日志绑定的业务流水号
     *
     * @return
     */
    //String businessNo();

    /**
     * 标识该条操作日志是否需要持久化存储
     * @return
     */
    boolean intoDb() default false;

    /**
     * 在方法成功执行后打点，记录方法的执行时间发送到指标系统，默认开启
     *
     * @return
     */
    boolean recordSuccessMetrics() default true;

    /**
     * 在方法成功失败后打点，记录方法的执行时间发送到指标系统，默认开启
     *
     * @return
     */
    boolean recordFailMetrics() default true;

    /**
     * 通过日志记录请求参数，默认开启
     *
     * @return
     */
    boolean logParameters() default true;

    /**
     * 通过日志记录方法返回值，默认开启
     *
     * @return
     */
    boolean logReturn() default true;

    /**
     * 出现异常后通过日志记录异常信息，默认开启
     *
     * @return
     */
    boolean logException() default true;

    /**
     * 出现异常后忽略异常返回默认值，默认关闭
     *
     * @return
     */
    boolean ignoreException() default false;
}
