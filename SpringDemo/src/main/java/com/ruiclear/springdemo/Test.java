package com.ruiclear.springdemo;

/**
 * Created by RuiClear on 2017/12/10.
 */
public class Test {
    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
//        HelloWorld helloWorld = (HelloWorld)context.getBean("helloWorld");
       // System.out.println(helloWorld);
        //helloWorld.say();
//         User user = (User)context.getBean("user");
//        System.out.println(user);
//        ((ClassPathXmlApplicationContext)context).close();

 Server server = (Server) new ServerPorxy(new ServerImpl2()).getInstacne();
 server.say();
    }
}
