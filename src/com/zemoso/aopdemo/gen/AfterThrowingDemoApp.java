package com.zemoso.aopdemo.gen;

import com.zemoso.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterThrowingDemoApp {

    public static void main(String arg[]){
        //read the spring config class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring
        AccountDAO accountDAO = context.getBean("accountDAO",AccountDAO.class);

        // call the method created for after return:
        List<Account> accounts = null;
        try{
            boolean tripWire = true;
            accounts =accountDAO.findAccounts(tripWire);

        }
        catch (Exception exc){
            System.out.println("\n\n Main Program Caught Exception");
        }


        System.out.println("Main Program: After Throwing");
        System.out.println(accounts);


        //close the context
        context.close();
    }

}
