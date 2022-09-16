package com.miku;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class ReiJiApplication {
    public static void main(String[] args) {
        log.info("项目开始启动");
        SpringApplication.run(ReiJiApplication.class,args);
    }
}
