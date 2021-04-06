package com.rain.study;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.rain.study.mapper")
@SpringBootApplication
public class BootMybatisPlusStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootMybatisPlusStudyApplication.class, args);
    }

}
