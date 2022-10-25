package com.startdis.common.log.annotation;

import com.startdis.common.log.config.LogRecordAutoConfigure;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author DianJiu
 * @email dianjiusir@gmail.com
 * @date 2022-07-19
 * @desc 日志记录开启注解
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(LogRecordAutoConfigure.class)
@Documented
@Inherited
public @interface EnableLogRecord {

}