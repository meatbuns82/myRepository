package com.luwenhua.springboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication

//@MapperScan(basePackages = {"com.luwenhua.springboot.mapper"})
public class SpringBoot01HelloWorldQucikApplication {
    public static void main(String[] args) {

        SpringApplication.run(SpringBoot01HelloWorldQucikApplication.class,args);
        log.info("---配置类---日志启动");
    }

}
