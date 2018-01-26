package com.ruiclear.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
