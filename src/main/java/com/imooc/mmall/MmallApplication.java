package com.imooc.mmall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.imooc.mmall.dao")
public class MmallApplication {

    public static void main(String[] args) {

        SpringApplication.run(MmallApplication.class, args);
    }

}
