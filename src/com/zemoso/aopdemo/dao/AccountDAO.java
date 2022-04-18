package com.zemoso.aopdemo.dao;

import com.zemoso.aopdemo.gen.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    private String name;
    private String serviceCode;



    // add a new method : findAccounts()

    public List<Account> findAccounts(boolean tripWire){

        // stimulate the exception based on trip wire

        if(tripWire){
            throw new RuntimeException("Exception triggered");
        }

        List<Account> accounts = new ArrayList<>();

        // create some account objects and add to the list:

        Account temp1 = new Account("Shanker","Platinum");
        Account temp2 = new Account("Vineet","Gold");
        Account temp3  = new Account("Kalyan","Silver");

        accounts.add(temp1);
        accounts.add(temp2);
        accounts.add(temp3);
        return accounts;
    }


    public String getName() {
        System.out.println(getClass() + "In getName()");
        return name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + "In getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + "In setServiceCode()");
        this.serviceCode = serviceCode;
    }

    public void setName(String name) {
        System.out.println(getClass() + "In setName()");
        this.name = name;
    }

    public void addAccount(Account account, boolean vipFlag){
        System.out.println(getClass() + " :Doing MY DB WORK: Adding an account ");
    }

}
