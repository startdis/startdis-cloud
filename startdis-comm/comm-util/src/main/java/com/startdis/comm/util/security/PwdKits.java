package com.startdis.comm.util.security;

import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

public class PwdKits {

//    private final static String DEFAULT_PASS="Tdcd123456";

    private final static String DEFAULT_PASS="123456";


    public static boolean isValidPassword(String password,String encodePassword) {
        return encode(password).equals(encodePassword);
    }


    public static String encode(String s){
        return DigestUtils.md5DigestAsHex(s.getBytes(StandardCharsets.UTF_8));
    }

    public static String getDefaultPassEncryption(){
        return encode(DEFAULT_PASS);
    }

    public static void main(String[] args) {
        System.out.println(getDefaultPassEncryption());
        //System.out.println(encode("111111"));
    }
}
