package com.barry.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 不开启security验证:
 * @SpringBootApplication(exclude = {SecurityAutoConfiguration.class, ManagementWebSecurityAutoConfiguration.class})
 * */
@SpringBootApplication
@ComponentScan(basePackages={"com.barry.security.browser"})
@RestController
public class DemoAppStarter {

    public static void main(String[] args) {
        SpringApplication.run(DemoAppStarter.class, args);
    }



}
