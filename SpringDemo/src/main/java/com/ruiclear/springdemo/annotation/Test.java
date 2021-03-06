package com.ruiclear.springdemo.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by RuiClear on 2017/12/10.
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext-annotation.xml");
        HelloWorld helloWorld = (HelloWorld)context.getBean("helloWorld");
        System.out.println(helloWorld);
        helloWorld.say();

    }
}
