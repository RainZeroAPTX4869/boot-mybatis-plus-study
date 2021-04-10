package com.rain.study;

import com.rain.study.utils.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.Jedis;

@SpringBootTest
class BootMybatisPlusStudyApplicationTests {

    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    RedisUtil redisUtil;

    @Test
    void jedisTest() {
        Jedis jedis = new Jedis("192.168.0.200", 6379);
        jedis.auth("root");
        System.out.println("服务正在运行: " + jedis.ping());
    }

    @Test
    void redisTest() {
//        操作字符串
        redisUtil.set("fname","rain");
        redisUtil.set("lname","zero");
        System.out.println(redisUtil.get("fname"));
        System.out.println(redisUtil.get("lname"));
        System.out.println(redisUtil.get("name"));

    }

}
