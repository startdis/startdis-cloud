package com.startdis.comm.util.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.*;

/**
 * @author DianJiu
 * @email lidianjiu@njydsz.com
 * @date 2022-07-26
 * @desc
 */
public class JwtKits {
    /**
     * 设置过期时间及密匙
     * CALENDAR_FIELD 时间单位
     * CALENDAR_INTERVAL 有效时间
     * SECRET_KEY 密匙
     */
    public static final int CALENDAR_FIELD = Calendar.MINUTE;
    public static final int CALENDAR_INTERVAL = 60 * 24;
    private static final String SECRET_KEY = "5ee022e13d7540d684b0ec152510fcdb";

    /**
     * 创建Token
     *
     * @param userMap 自己需要存储进token中的信息
     * @return token
     */
    public static String encrypt(Map<String, Object> userMap) {
        // 头部
        Map<String, Object> headerMap = new HashMap<>(4);
        headerMap.put("alg", "HS256");
        headerMap.put("typ", "JWT");

        // 当前时间与过期时间
        Calendar time = Calendar.getInstance();
        Date now = time.getTime();
        time.add(CALENDAR_FIELD, CALENDAR_INTERVAL);
        Date expireTime = time.getTime();

        // 选择签名加密算法
        Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);

        // 创建token并返回
        return JWT.create().withHeader(headerMap)
                .withIssuedAt(now)
                .withExpiresAt(expireTime)
                .withSubject("user")
                .withClaim("userInfo", userMap)
                .sign(algorithm);
    }

    /**
     * 验证、解析Token
     *
     * @param token 用户提交的token
     * @return 该token中的信息 decrypt
     */
    public static Map<String, Object> decrypt(String token) {
        DecodedJWT verifier = null;
        Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
        try {
            verifier = JWT.require(algorithm).build().verify(token);
        } catch (Exception e) {
            //JSONObject jsonObject = new JSONObject();
            //jsonObject.put("status", "401");
            //jsonObject.put("msg", "验证失败，请重新登录!");
            // TODO: 处理验证异常
        }
        assert verifier != null;
        return verifier.getClaim("userInfo").asMap();
    }

    public static void main(String[] args) {
        /**
         *  测试加密
         */
        HashMap<String, Object> map = new HashMap<>();
        String uuid = String.valueOf(UUID.randomUUID()).replace("-", "");
        System.out.println(uuid);
        map.put("uuid", uuid);
        String token = encrypt(map);
        System.out.println(token);
        /**
         * 测试解密
         */
        Map<String, Object> objectMap = decrypt(token);
        System.out.println(objectMap.get("uuid"));
    }
}
