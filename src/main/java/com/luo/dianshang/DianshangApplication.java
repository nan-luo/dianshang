package com.luo.dianshang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.luo.dianshang.mapper")
public class DianshangApplication {

    public static void main(String[] args) {
        SpringApplication.run(DianshangApplication.class, args);
    }

}
