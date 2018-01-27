package com.ruiclear.controller;

import com.ruiclear.annotation.JzController;
import com.ruiclear.annotation.JzParam;
import com.ruiclear.annotation.JzRequestMapping;

/**
 * Created by RuiClear on 2018/1/27.
 */
@JzController
@JzRequestMapping("/controller")
public class JzOpenController {
    @JzRequestMapping(value="/open",method = "POST")
    public void open(@JzParam("name") String name){
        System.out.println("open");
    }
}
