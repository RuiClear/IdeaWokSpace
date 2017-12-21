package com.ruiclear.springdemo.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by RuiClear on 2017/12/16.
 */
@Aspect
@Component
public class LoggingAspectJ {
    @Pointcut("execution(public * com.ruiclear.springdemo.annotation.HelloWorld.say())")
    public void JointPointExpression(){}
    @Before("com.ruiclear.springdemo.annotation.LoggingAspectJ.JointPointExpression()")
    public void befores(JoinPoint joinPoint){
        System.out.println("begain mthod："+joinPoint.getSignature().getName()+",args："+ Arrays.asList(joinPoint.getArgs()));
    }
    @After("execution(public * com.ruiclear.springdemo.annotation.HelloWorld.say())")
    public void after(JoinPoint joinPoint){
        System.out.println("end mthod："+joinPoint.getSignature().getName()+",args："+Arrays.asList(joinPoint.getArgs()));
    }
    @AfterReturning(value="execution(public * com.ruiclear.springdemo.annotation.HelloWorld.say())",returning = "result")
    public void afterRunning(JoinPoint joinPoint,Object result){
        System.out.println("end mthod："+joinPoint.getSignature().getName()+",args："+Arrays.asList(joinPoint.getArgs())+",result:"+result);
    }
    @AfterThrowing(value="execution(public * com.ruiclear.springdemo.annotation.HelloWorld.say())",throwing = "e")
    public void aferThrowing(JoinPoint joinPoint,Exception e){
        System.out.println("end mthod："+joinPoint.getSignature().getName()+",args："+Arrays.asList(joinPoint.getArgs())+",exception:"+e);
    }
    @Around("execution(public * com.ruiclear.springdemo.annotation.HelloWorld.say())")
    public Object around(ProceedingJoinPoint proceedingJoinPoint){
         Object result = null;
         try{
             //此处可以写前置通知代码
             result = proceedingJoinPoint.proceed();
             //此处可以写返回置通知代码
         }catch (Throwable e){
             //此处可以写后置异常代码
             throw new RuntimeException(e);
         }
        //此处可以写后置通知代码
        return  result;
    }
}
