package com.halfsummer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.**.mapper")
public class BaseFrameworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaseFrameworkApplication.class, args);
    }

}
