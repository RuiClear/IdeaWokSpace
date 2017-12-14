package com.ruiclear.springdemo;

import org.springframework.stereotype.Service;

/**
 * Created by RuiClear on 2017/12/14.
 */
@Service
public class ServerImpl implements Server {
    public void say() {
        System.out.println("ServerImpl");
    }
}
