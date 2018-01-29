package com.ruiclear.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    @ResponseBody
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public String delete(@PathVariable String id){
        System.out.println("Delete:"+id);
        return "success";
    }
    @RequestMapping("/hello/{id}/{name}")
    public String hello(@PathVariable Double id,@PathVariable("name") String name){
        System.out.println("hello:"+id+","+name);
        return "success";
    }
}
