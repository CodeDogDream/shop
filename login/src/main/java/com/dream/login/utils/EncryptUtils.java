package com.dream.login.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.UUID;

/**
 * @author Dream
 * @date 2017/8/15
 * 生成盐，以及加密算法
 */
public class EncryptUtils {
    //获取盐
    public static String getSalt() {
        Random random = new Random();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            builder.append(random.nextInt(88888)).append(random.nextInt(77777));
        }
        return getMd5(builder.toString());
    }

    //获取md5加密后的密码，即存到数据库的代码
    public static String getMd5Pwd(String salt, String password) {
        return getMd5(password + salt);
    }

    //MD5算法
    public static String getMd5(String plainText) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte b[] = md.digest();

            int i;

            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0) {
                    i += 256;
                }
                if (i < 16) {
                    buf.append("0");
                }
                buf.append(Integer.toHexString(i));
            }
            //32位加密
            return buf.toString();
            // 16位的加密
            //return buf.toString().substring(8, 24);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        return str.replace("-", "");
    }


    public static String makeToken(String username, String uid) {
        return getMd5(username + uid);
    }

}
