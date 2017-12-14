package com.ruiclear.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;

/**
 * Created by RuiClear on 2017/12/10.
 */
@Component
public class HelloWorld {
    private String name;
    @Resource
    private User user;
    @Autowired
    @Qualifier("serverImpl2")
    private Server server;

    public void say() {
        System.out.println("你好：" + user);
        server.say();
    }
}
