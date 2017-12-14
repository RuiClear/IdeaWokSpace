package com.ruiclear.springdemo;

import org.springframework.stereotype.Repository;

/**
 * Created by RuiClear on 2017/12/11.
 */
@Repository
public class User {
    private String name;
    private int age;

    public String getName() {

        return name;
    }

    public void setName(String name) {

        System.out.println("setname");
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User() {
        System.out.println("user");
    }
}
