package com.jbk.aspect;
import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MessageAspect {

	
	@After("execution(public void deposit())")
	public void sendSms() {
		System.out.println("Sms is send to client");
	}
	
	@After ("execution (public void deposit1(..))")
	void sendSMS(JoinPoint jt) {
		System.out.println("Send SMS To Client");
		System.out.println("Your Depoist Amount is "+Arrays.toString(jt.getArgs()));
		System.out.println("Joint Point method is "+jt.getSignature());
		System.out.println("Joint Point method name is "+jt.getSignature().getName());
	}
	
	@Before("execution(public void withdraw())")
	public void validPin1() {
		System.out.println("Enter pin before withdraw for validation");
	}
	
	@Before("execution(public void withdraw1(..))")
	public void withAmt(JoinPoint jt1) {
		System.out.println("withdrawl amt is"+Arrays.toString(jt1.getArgs()));
	}
	
	//Due to this "execution(com.jbk.entity.Account.*(..))" validPin method is executed 
	//before all methods of account class and same for @after annotation
	@Before("execution (* com.jbk.entity.Account.* (..))")
	public void validPin() {
		System.out.println("Enter pin before validation");
	}
	@Around("execution (public void deposit(..))")
	public void AroundmyMEthod(ProceedingJoinPoint p) {
		
		System.out.println("========Before Method Pin Valid Logic=====");
		
		try {
			p.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Send sms logic
		
		System.out.println("========After Method Send SMS Logic=====");
		
	}
	
//	@Around("execution (* com.jbk.entity.Account.*(..))")//Around for all
//	public void AroundmyMEthod(ProceedingJoinPoint p) {
//		
//		System.out.println("========Before Method Pin Valid Logic=====");
//		
//		try {
//			p.proceed();
//		} catch (Throwable e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		//Send sms logic
//		
//		System.out.println("========After Method Send SMS Logic=====");
//		
//	}
	

	@AfterReturning(pointcut = "execution (* com.jbk.entity.Account.*(..))",
			returning="myMsg")
	public void CheckReturning(String myMsg) {
		System.out.println("Your MSG is==>> "+myMsg);
	}
	
	
	@AfterThrowing(pointcut = "execution (* com.jbk.entity.Account.*(..))",
			throwing = "ex")
	public void CatchThrow(Exception ex) {
		ex.printStackTrace();
	}
}
