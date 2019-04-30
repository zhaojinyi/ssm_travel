package com.zjy;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Auther: 无聊的人
 * @Date: 2019/4/29
 * @Description: com.zjy
 */
public class BCryptPasswordEncoderUtild {

    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public static String encodePassword(String password) {
        return bCryptPasswordEncoder.encode(password);
    }

    public static void main(String[] args) {
        String password="812912";
        String str = bCryptPasswordEncoder.encode(password);
        System.out.println(str);
    }
}
