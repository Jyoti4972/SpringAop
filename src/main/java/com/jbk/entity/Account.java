package com.jbk.entity;

import org.springframework.stereotype.Component;

@Component
public class Account {

	double accBalance=100000;
	
	public void deposit() {
		// TODO Auto-generated method stub
		System.out.println("Deposit Amount---");
	}
	
	public void deposit1(double amt) {
		System.out.println("Deposit Amount is--");
	}
	
	public void withdraw() {
		System.out.println("Amount withdraw...");
	}
	public void withdraw1(int amt) {
		System.out.println("Amount withdraw...");
	}
	
	public String withdrawCondition() {
		if(this.accBalance<1000) {
			return "Insufficient balance";
		}
		else {
			return "Thank You for banking";
		}
	}
	
	public String checkException() {
		

		try {
		int val = 10/0;
		
		}
		catch(Exception e) {
			System.out.println("In Catch Block");
		}		
		finally {
			System.out.println("Simple");
		} 
		return "hello";
	}
	
}
