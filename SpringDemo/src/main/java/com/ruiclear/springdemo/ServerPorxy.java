package com.ruiclear.springdemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by RuiClear on 2017/12/14.
 */
public class ServerPorxy {
    private Server server;
    public ServerPorxy(Server server){
        this.server = server;
    }
    public Object getInstacne(){
        return Proxy.newProxyInstance(server.getClass().getClassLoader(), new Class[]{Server.class}, new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                Object result = null;
                //这个位置相当于前置通知
                try{
                    result = method.invoke(server, args);
                    //这个位置相当于返回通知
                 }catch (Exception e){
                    e.printStackTrace();
                    //这个位置相当于异常通知
                }
                //这个位置相当于后置通知
                return result;
            }
        });
    }
}
