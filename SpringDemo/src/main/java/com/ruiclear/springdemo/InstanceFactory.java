package com.ruiclear.springdemo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by RuiClear on 2017/12/13.
 */
public class InstanceFactory {
    private Map<String,User> map = new HashMap<String, User>();
    public InstanceFactory(){
        map.put("jack",new User("jack",34));
        map.put("tom",new User("tom",21));
    }
    public User getUser(String name){
        return map.get(name);
    }
}
