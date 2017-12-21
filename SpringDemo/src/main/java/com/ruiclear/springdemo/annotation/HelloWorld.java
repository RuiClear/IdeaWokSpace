package com.ruiclear.springdemo.annotation;

import org.springframework.stereotype.Component;

/**
 * Created by RuiClear on 2017/12/10.
 */
@Component
public class HelloWorld {

    public String  say() {
        System.out.println("say method");
        int i = 10/0;
        return "rui";
    }
}
