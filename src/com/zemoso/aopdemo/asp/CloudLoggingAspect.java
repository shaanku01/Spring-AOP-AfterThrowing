package com.zemoso.aopdemo.asp;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class CloudLoggingAspect {

    @Before("com.zemoso.aopdemo.asp.AopExpressions.forDaoPackageNoGetterSetter()")
    public void method3(){
        System.out.println("Logging to cloud function");
    }
}
