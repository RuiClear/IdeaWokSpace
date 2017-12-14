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
                System.out.println(proxy.getClass().getName());
                System.out.println("之前");
                Object  result = method.invoke(server,args);
                System.out.println("之后");
                return result;
            }
        });
    }
}
