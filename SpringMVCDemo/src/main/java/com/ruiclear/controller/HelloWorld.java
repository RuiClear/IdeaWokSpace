package com.ruiclear.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by RuiClear on 2018/1/24.
 */
@Controller
@SessionAttributes(value = "user")
public class HelloWorld {
    @RequestMapping("/say")
    public String say(){
        System.out.println("Hello World!");
        return "forward:/WEB-INF/success.jsp";
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
    @RequestMapping("/session")
    public String session(Map<String,Object> map){
        System.out.println("session");
        map.put("date",new Date());
        return "success";
    }
    @ModelAttribute
    public void model(@RequestParam(value="id",required=false)Integer id,Map<String,Object> map){
        System.out.println("model Attribute");
        if(id!=null){
            User user = new User(4,"wang",22,"men");
            System.out.println(user);
            map.put("user",user);
        }
    }
    @RequestMapping("/testModel")
    public String testModel(User user){
        System.out.println(user);
        return "success";
    }
    @RequestMapping("/testhello")
    public String testhello(){
        System.out.println("testhello");
        return "helloView";
    }
    @ResponseBody
    @RequestMapping("/json")
    public List<User> testJson(){
        List<User> list = new ArrayList<User>();
        list.add(new User(1,"jack",21,"famale"));
        list.add(new User(1,"tom",20,"male"));
        return list;
    }

}
