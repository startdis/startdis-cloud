package com.startdis.comm.redis.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.time.Duration;

@Configuration
public class JedisConfig {

    @Value("${spring.redis.host:}")
    private String host;

    @Value("${spring.redis.port:6379}")
    private int port;

    @Value("${spring.redis.password:}")
    private String password;

    @Value("${spring.redis.database:0}")
    private int database;

    @Value("${spring.redis.jedis.pool.max-active:0}")
    private int maxActive;

    @Value("${spring.redis.jedis.pool.max-idle:0}")
    private int maxIdle;

    @Value("${spring.redis.timeout:0}")
    private int timeout;

    @Bean
    public JedisPool jedisPool() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setJmxEnabled(false);
        jedisPoolConfig.setMaxTotal(maxActive);
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxWait(Duration.ofMillis(timeout));
        JedisPool pool = new JedisPool(jedisPoolConfig, host, port, timeout, password, database);
        return pool;
    }

}
