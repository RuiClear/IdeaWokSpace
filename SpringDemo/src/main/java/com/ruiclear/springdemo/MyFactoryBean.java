package com.ruiclear.springdemo;

import org.springframework.beans.factory.FactoryBean;

/**
 * Created by RuiClear on 2017/12/13.
 */
public class MyFactoryBean implements FactoryBean<User>{
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public User getObject() throws Exception {
        return new User(name,22);
    }

    public Class<?> getObjectType() {
        return User.class;
    }

    public boolean isSingleton() {
        return true;
    }
}
