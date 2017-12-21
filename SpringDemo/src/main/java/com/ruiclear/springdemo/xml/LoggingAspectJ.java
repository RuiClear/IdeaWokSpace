package com.ruiclear.springdemo.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Arrays;

/**
 * Created by RuiClear on 2017/12/16.
 */
public class LoggingAspectJ {

    public void befores(JoinPoint joinPoint){
        System.out.println("begain mthod："+joinPoint.getSignature().getName()+",args："+ Arrays.asList(joinPoint.getArgs()));
    }
    public void after(JoinPoint joinPoint){
        System.out.println("end mthod："+joinPoint.getSignature().getName()+",args："+Arrays.asList(joinPoint.getArgs()));
    }
    public void afterRunning(JoinPoint joinPoint,Object result){
        System.out.println("end mthod："+joinPoint.getSignature().getName()+",args："+Arrays.asList(joinPoint.getArgs())+",result:"+result);
    }
    public void aferThrowing(JoinPoint joinPoint,Exception e){
        System.out.println("end mthod："+joinPoint.getSignature().getName()+",args："+Arrays.asList(joinPoint.getArgs())+",exception:"+e);
    }
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
