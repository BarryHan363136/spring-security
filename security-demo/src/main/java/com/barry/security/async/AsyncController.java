package com.barry.security.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

@RestController
public class AsyncController {

    private static final Logger log = LoggerFactory.getLogger(AsyncController.class);

    @GetMapping("/order")
    public Callable<String> order(){
        log.info("<========主线程开始=========>");
        Callable<String> result = new Callable<String>() {

            @Override
            public String call() throws Exception {
                log.info("<========副线程开始=========>");
                Thread.sleep(1000);
                log.info("<========副线程开始=========>");
                return "success";
            }
        };
        log.info("<========主线程开始=========>");
        return result;
    }

}
