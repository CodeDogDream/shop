package com.dream.login;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginApplicationTests {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    public void contextLoads() {
        ValueOperations<String, String> value = redisTemplate.opsForValue();
        value.set("root", "dream", 10, TimeUnit.SECONDS);
        System.out.println(value.get("root"));
    }

}
