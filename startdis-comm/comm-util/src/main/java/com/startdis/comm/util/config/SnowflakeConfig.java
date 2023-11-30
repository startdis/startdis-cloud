package com.startdis.comm.util.config;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.startdis.comm.util.hash.HashUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author DianJiu
 * @email lidianjiu@njydsz.com
 * @date 2022-07-28
 * @desc
 */
@Component
@Slf4j
public class SnowflakeConfig {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private long workerId ;//为终端ID
    private long datacenterId = 1;//数据中心ID
    private Snowflake snowflake = IdUtil.getSnowflake(workerId,datacenterId);

    @PostConstruct
    public void init(){
        workerId = NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
        log.info("当前机器的workId:{}",workerId);
    }
    public synchronized long snowflakeId(){
        return snowflake.nextId();
    }

    public synchronized String nextShortId(){
        return HashUtils.hashToBase62(snowflake.nextIdStr());
    }

    public synchronized String nextIdStr(){
        return snowflake.nextIdStr();
    }

    public synchronized long snowflakeId(long workerId,long datacenterId){
        Snowflake snowflake = IdUtil.getSnowflake(workerId, datacenterId);
        return snowflake.nextId();
    }
}

