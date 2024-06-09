package com.dr1.tp3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Dr1Tp3Application {

    public static void main(String[] args) {
        SpringApplication.run(Dr1Tp3Application.class, args);
    }

}
