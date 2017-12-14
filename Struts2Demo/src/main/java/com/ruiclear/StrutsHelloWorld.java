package com.ruiclear;

import com.opensymphony.xwork2.ActionSupport;
import com.ruiclear.dao.User;

/**
 * Created by RuiClear on 2017/11/28.
 */
public class StrutsHelloWorld {
    private User user;
    public String excute(){
        System.out.println("Hello World.."+user);
        return "success";
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
