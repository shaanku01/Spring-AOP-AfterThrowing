package com.zemoso.aopdemo.asp;


import com.zemoso.aopdemo.gen.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(1)
public class SampleAspect {


    @AfterThrowing(
            pointcut = "execution(* com.zemoso.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "exe"
    )
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint,Throwable exe){

        // printing the method we are advising on...
        String methodName = joinPoint.getSignature().toShortString();
        System.out.println("\n =========> Executing the AfterThrowing advice on method:"+methodName);

        //log the exception
        System.out.println("\n =========> Exception is"+exe);


    }




    // adding a new advice for @AfteReturning on findAccounts Method:

    @AfterReturning(
            pointcut = "execution(* com.zemoso.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result){
        String methodName = joinPoint.getSignature().toShortString();
        System.out.println("\n =========> Executing the AfterReturning advice on method:"+methodName);
        System.out.println("\n Result of the method:"+result);

        // Post process the data and modify it.



        // convert the account names to uppercase:
        convertAccountNamesToUpperCase(result);

        System.out.println("\n Result of the method After Modification:"+result);


    }

    private void convertAccountNamesToUpperCase(List<Account> result) {

        for(Account temp : result){
            String upperName = temp.getName().toUpperCase();
            temp.setName(upperName);
        }
    }

    @Before("com.zemoso.aopdemo.asp.AopExpressions.forDaoPackage()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint){
        System.out.println(" \n\n\n======> Executing advice on addAccount()");

        //Display the method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method Signature:" + methodSignature);


        //Display the method arguments
        // get the arguments
        Object[] args = joinPoint.getArgs();

        //loop through the arguments
        for(Object temp : args){
            System.out.println(temp);

            if(temp instanceof Account){
                Account tempAccount  = (Account) temp;

                System.out.println(tempAccount.getName());
                System.out.println(tempAccount.getLevel());

            }
        }

    }
}
