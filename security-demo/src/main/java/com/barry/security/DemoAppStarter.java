package com.barry.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 不开启security验证:
 * @SpringBootApplication(exclude = {SecurityAutoConfiguration.class, ManagementWebSecurityAutoConfiguration.class})
 * */
@SpringBootApplication
public class DemoAppStarter {

    public static void main(String[] args) {
        SpringApplication.run(DemoAppStarter.class, args);
    }



}
