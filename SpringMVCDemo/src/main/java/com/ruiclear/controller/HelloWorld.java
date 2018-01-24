package com.ruiclear.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by RuiClear on 2018/1/24.
 */
@Controller
public class HelloWorld {
    @RequestMapping("/say")
    public String say(){
        System.out.println("Hello World!");
        return "success";
    }
}
