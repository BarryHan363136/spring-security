package com.barry.security.controller;

import com.barry.security.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    //@GetMapping("/hello")
    @RequestMapping(value="/hello")
    public String hello(){
        return "hello spring security!";
    }

    /**
     * ReflectionToStringBuilder.toString(new User(), ToStringStyle.MULTI_LINE_STYLE);
     * 分页参数: @PageableDefault(page = 1, size = 50, sort = "username,asc") Pageable pageable
     * */
    @GetMapping("/user")
    public List<User> query(@RequestParam(value = "username", required = false, defaultValue = "中国人民") String username){
        logger.info("=====>query username:{}", username);

        List<User> list = new ArrayList<>();
        list.add(new User());
        list.add(new User());
        list.add(new User());
        return list;
    }

}
