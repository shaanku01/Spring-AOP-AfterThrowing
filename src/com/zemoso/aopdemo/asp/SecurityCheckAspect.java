package com.zemoso.aopdemo.asp;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class SecurityCheckAspect {
    @Before("com.zemoso.aopdemo.asp.AopExpressions.forDaoPackageNoGetterSetter()")
    public void method2(){
        System.out.println("Security Checks going on -----   finished");
    }


}
