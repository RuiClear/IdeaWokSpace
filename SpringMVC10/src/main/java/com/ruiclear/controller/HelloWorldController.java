package com.ruiclear.controller;

import com.ruiclear.annotation.JzController;
import com.ruiclear.annotation.JzParam;
import com.ruiclear.annotation.JzRequestMapping;

/**
 * Created by RuiClear on 2018/1/29.
 */
@JzController
@JzRequestMapping("/controller")
public class HelloWorldController {
    @JzRequestMapping("/helloWorld")
    public void helloWorld(){
        System.out.println("Hello World!");
    }
    @JzRequestMapping("/doSomething")
    public void doSomething(@JzParam("name")String name,@JzParam("id") Double id,@JzParam("age") Integer age){
        System.out.println("doSomething:"+name+","+id+","+age);
    }
}
