package com.ruiclear.springdemo;

/**
 * Created by RuiClear on 2017/12/10.
 */
public class HelloWorld {
    private String name;
    public void say(){
        System.out.println("Hello:"+name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
