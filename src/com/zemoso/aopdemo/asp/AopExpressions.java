package com.zemoso.aopdemo.asp;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopExpressions {

    @Pointcut("execution( * com.zemoso.aopdemo.dao.*.*(..))")
    public void forDaoPackage(){}

    //point cut for getter methods
    @Pointcut("execution( * com.zemoso.aopdemo.dao.*.get*(..))")
    public void getter(){}

    //Point cut for setter methods
    @Pointcut("execution( * com.zemoso.aopdemo.dao.*.set*(..))")
    public void setter(){}

    //Create a new point cut which include the package but exclude the getter and setter.
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter(){}


}
