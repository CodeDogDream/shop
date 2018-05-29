package com.dream.service.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;


/**
 * Created by Dream
 * 2018/5/27.
 * 19:29
 * Redis 的相关操作封装
 *
 * @author Dream
 */
public class RedisUtils {
    @Autowired
    private static StringRedisTemplate stringRedisTemplate;
    private static Logger logger = LoggerFactory.getLogger(RedisUtils.class);

    //设置redis的key永久有效
    public static String setStringData(String key, String value) {
        try {
            stringRedisTemplate.opsForValue().set(key, value);
        } catch (Exception e) {
            logger.error("setObject设置redis键值异常:key=" + key + " value=" + value + " cause:" + e.getMessage());
            return null;
        }
        return value;
    }

    //根据redis的key获取值
    public static String getStringData(String key) {
        try {
            return stringRedisTemplate.opsForValue().get(key);
        } catch (Exception e) {
            logger.error("获取数据错误，key=" + key + "cause：" + e.getMessage());
            return null;
        }
    }

    //设置redis的key后面是时间
    public static String setStringData(String key, String value, int expireTime) {
        try {
            stringRedisTemplate.opsForValue().set(key, value, expireTime);
        } catch (Exception e) {
            logger.error("setObject设置redis键值异常:key=" + key + " value=" + value + " cause:" + e.getMessage());
            return null;
        }
        return value;
    }


}
