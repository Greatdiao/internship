package com.odianyun.internship;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.ImmutableMap;
import com.odianyun.internship.model.UUser;
import com.odianyun.internship.startup.Application;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: EDZ
 * @time: 14:16
 * @date: 2021/7/20
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class RedisTest {

    @Resource
    private RedisTemplate<String, Serializable> redisTemplate;

    @Test
    public void testStringSet() {
        ValueOperations operations = redisTemplate.opsForValue();
        // 设值
        String key = "userName:2";
        operations.set(key, "xingguo");
        // 使用最后一个
        operations.set(key, "xingguo123");
        // 获取值
        System.out.println("value = " + operations.get(key));
    }

    @Test
    public void testStringExpire() throws InterruptedException {
        ValueOperations operations = redisTemplate.opsForValue();
        String key = "userCaptchas:1";
        // 设置过期时间
        operations.set(key, "435678", 3, TimeUnit.SECONDS);
        System.out.println("value = " + operations.get(key));
        Thread.sleep(4000);
        System.out.println("4s之后value = " + operations.get(key));
    }

    @Test
    public void testStringSetIfAbsent() throws InterruptedException {
        ValueOperations operations = redisTemplate.opsForValue();
        String key = "userName:2";
        String key3 = "userName:3";
        String key6 = "userName:6";
        // 如果不存在，则设置一个key和value。如果存在则不改变
        operations.setIfAbsent(key, "diaoxingguo2");
        operations.setIfAbsent(key3, "diaoxingguo3");
        operations.setIfAbsent(key6, "diaoxingguo6");
        System.out.println("key value = " + operations.get(key));
        System.out.println("key3 value = " + operations.get(key3));
        System.out.println("key6 value = " + operations.get(key6));
    }

    @Test
    public void testStringSetIfPresent() throws InterruptedException {
        ValueOperations operations = redisTemplate.opsForValue();
        String key = "userName:2";
        String key3 = "userName:3";
        String key8 = "userName:8";
        // 如果key存在就使用新值覆盖，如果key不存在，则不赋值
        operations.setIfPresent(key, "diaoxingguo2");
        operations.setIfPresent(key3, "diaoxingguo3");
        operations.setIfPresent(key8, "diaoxingguo8");
        System.out.println("key value = " + operations.get(key));
        System.out.println("key3 value = " + operations.get(key3));
        System.out.println("key8 value = " + operations.get(key8));
    }

    @Test
    public void testStringMultiSet() {
        ValueOperations operations = redisTemplate.opsForValue();
//        Map<String, String> map = new HashMap<>();
//        Map<String, String> map = Maps.newHashMap();
//        map.put("", "");
        // 批量设置key和value
        Map<String, String> map = ImmutableMap.of(
                "userName:101", "张三",
                "userName:102", "李四",
                "userName:103", "刘汝清"
        );
        operations.multiSet(map);
        // 获取单个key
        System.out.println("userName:101 value = " + operations.get("userName:101"));

        // 获取批量key的值
        List<String> multiValues = operations.multiGet(Lists.newArrayList("userName:101", "userName:102", "userName:103"));

        multiValues.forEach(System.out::println);

        /*multiValues.forEach(item -> System.out.println(item));

        for(String item : multiValues) {
            System.out.println(item);
        }*/

        List<String> filterList = multiValues.stream().filter(item -> !item.equals("张三")).collect(Collectors.toList());
        System.out.println("filterList = " + JSONObject.toJSONString(filterList));

        /*List<String> filterList = Lists.newArrayList();
        for(String item : multiValues) {
            if(!item.equals("张三")) {
                filterList.add(item);
            }
        }*/
    }

    @Test
    public void testStringIncrement() {
        ValueOperations operations = redisTemplate.opsForValue();
        String key = "url:query:num";
        Long maxNum = 10L;
        Long num = 0L;
        operations.set(key, 0);
        while (maxNum.compareTo(num) > 0) {
            // 加值
            num = operations.increment(key);
            System.out.println("num = " + num);
        }
    }

    @Test
    public void testStringIncrementWithDelta() {
        ValueOperations operations = redisTemplate.opsForValue();
        String key = "url:query:num";
        Long maxNum = 10L;
        Long num = 0L;
        Long delta = 2L;
        operations.set(key, 0);
        while (maxNum.compareTo(num) > 0) {
            // 加值
            num = operations.increment(key, delta);
            System.out.println("num = " + num);
        }
    }

    @Test
    public void testStringDecrement() {
        ValueOperations operations = redisTemplate.opsForValue();
        String key = "url:query:num";
        Long minNum = 0L;
        Long num = 10L;
        Long delta = 2L;
        operations.set(key, num);
        while (num.compareTo(minNum) > 0) {
            // 减值
            num = operations.decrement(key, delta);
            System.out.println("num = " + num);
        }
    }

    @Test
    public void testStringGetAndSet() {
        ValueOperations operations = redisTemplate.opsForValue();
        String key = "url:query:num";
        String key3 = "url:query:num3";
        // 设置新值返回旧值，如果key不存在，旧值就是null
        /*System.out.println("getAndSet key value = " + operations.get(key));
        System.out.println("getAndSet key value = " + operations.getAndSet(key, 1000));
        System.out.println("getAndSet key value = " + operations.get(key));

        System.out.println("getAndSet key value = " + operations.get(key3));
        System.out.println("getAndSet key value = " + operations.getAndSet(key3, 1000));
        System.out.println("getAndSet key value = " + operations.get(key3));*/

        System.out.println("key3 value = " + operations.get(key3));
        // 判断key是否存在
        System.out.println("hasKey key3 = " + redisTemplate.hasKey(key3));
        // 删除key
        redisTemplate.delete(key3);
        System.out.println("key3 value = " + operations.get(key3));
        System.out.println("hasKey key3 = " + redisTemplate.hasKey(key3));

        System.out.println(JSONObject.toJSONString(operations.multiGet(Lists.newArrayList(key, key3))));
        redisTemplate.delete(Lists.newArrayList(key, key3));
        System.out.println(JSONObject.toJSONString(operations.multiGet(Lists.newArrayList(key, key3))));
    }

    @Test
    public void testObject() {
        ValueOperations<String, Serializable> operations = redisTemplate.opsForValue();
        String key = "userInfo:123";
        UUser user = new UUser();
        user.setId(123L);
        user.setMobile("13127787865");
        user.setPassword("123456");

        // 存放对象
        operations.set(key, user);

        UUser cacheUUser = (UUser) operations.get(key);

        System.out.println(JSONObject.toJSONString(cacheUUser));
    }

}
