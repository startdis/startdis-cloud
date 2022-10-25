package com.startdis.common.log.config;

import com.startdis.common.exception.custom.SystemException;
import com.startdis.common.log.aspect.LogRecordAspect;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author DianJiu
 * @email dianjiusir@gmail.com
 * @date 2022-07-19
 * @desc
 */
@Slf4j
@RefreshScope
@Configuration
public class LogRecordAutoConfigure {
    /**
     * 是否开启监控配置参数
     */
    @Value("${log.record.enabled}")
    private String enabledConfig;

    /**
     * 错误提醒
     */
    @PostConstruct
    protected LogRecordAspect init() {
        if (StringUtils.isBlank(enabledConfig)) {
            log.error("Please config the log.record.enabled property in application.yml file to enable log record function.");
            throw new SystemException("A0001", "Please config the log.record.enabled property in application.yml file to enable log record function.");
        }
        return new LogRecordAspect();
    }

    /**
     * 根据运行环境决定是否开启日志记录监控
     *
     * @return
     */
    //@Bean
    //@ConditionalOnProperty(prefix = "log.record", name = "enabled", havingValue = "true")
    //protected LogRecordAspect startLogRecord() {
    //    return new LogRecordAspect();
    //}
}
