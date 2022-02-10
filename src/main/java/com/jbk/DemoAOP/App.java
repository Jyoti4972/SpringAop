package com.jbk.DemoAOP;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jbk.entity.Account;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
      ApplicationContext context=new AnnotationConfigApplicationContext(ConfigClass.class);
      Account a=context.getBean(Account.class);
      a.deposit();
      a.deposit1(3224);
      a.withdraw();
      a.withdraw1(20000);
     a.withdrawCondition();
     a.checkException();
    
    
    }
}
