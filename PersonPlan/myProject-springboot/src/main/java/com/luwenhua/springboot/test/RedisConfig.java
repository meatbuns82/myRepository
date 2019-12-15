package com.luwenhua.springboot.test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RedisConfig {

//redisTemplate.opsForValue();//操作字符串
//redisTemplate.opsForHash();//操作hash
//redisTemplate.opsForList();//操作list
//redisTemplate.opsForSet();//操作set
//redisTemplate.opsForZSet();//操作有序set


    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @RequestMapping("/redis")
    public String  queryRedis(){
        //redisTemplate.delete("idea");
//        redisTemplate.opsForValue().set("idea","111");
//
        String redisIdea =(String) redisTemplate.opsForValue().get("idea");

        if(redisIdea== null){

        }

        return "成功";

    }




}
