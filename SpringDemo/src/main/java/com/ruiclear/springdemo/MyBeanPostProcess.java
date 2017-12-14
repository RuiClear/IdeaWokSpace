package com.ruiclear.springdemo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created by RuiClear on 2017/12/13.
 */
public class MyBeanPostProcess implements BeanPostProcessor{
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("before...."+s);
        return o;
    }

    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("after...."+s);

        return o;
    }
}
