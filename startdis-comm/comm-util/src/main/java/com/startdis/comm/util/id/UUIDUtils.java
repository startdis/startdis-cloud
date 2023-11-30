package com.startdis.comm.util.id;


import java.util.UUID;

public class UUIDUtils {

    /**
     * 生成带有-的UUID字符串
     * @return 带有-的UUID字符串
     */
    public static String uuid() {
        return UUID.randomUUID().toString();
    }

    /**
     * 生成不带有-的UUID字符串
     * @return 不带有-的UUID字符串
     */
    public static String simpleUuid() {
        return uuid().replaceAll("-", "");
    }

}

