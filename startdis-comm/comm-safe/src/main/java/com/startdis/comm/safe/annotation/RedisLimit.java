package com.startdis.comm.safe.annotation;

import com.startdis.comm.safe.enums.LimitType;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import java.lang.annotation.*;

@Inherited
@Documented
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Order(Ordered.HIGHEST_PRECEDENCE)
public @interface RedisLimit {
    /**
     * key
     */
    String key() default "";
    /**
     * Key的前缀
     */
    String prefix() default "";
    /**
     * 一定时间内最多访问次数
     */
    int count();
    /**
     * 给定的时间范围 单位(秒)
     */
    int period();
    /**
     * 限流的类型(用户自定义key或者请求ip)
     */
    LimitType limitType() default LimitType.CUSTOMER;
}
