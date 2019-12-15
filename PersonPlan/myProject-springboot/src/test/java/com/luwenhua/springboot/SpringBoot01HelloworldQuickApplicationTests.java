package com.luwenhua.springboot;

import com.luwenhua.springboot.test.RedisConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot01HelloworldQuickApplicationTests {

	@Autowired
	private RedisConfig redisConfig;
	@Test
	public void contextLoads() {
		redisConfig.queryRedis();
	}



}
