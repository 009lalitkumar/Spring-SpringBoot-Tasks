package com.ATMMachine;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {
		
AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		WithdrawalEventPublisher publisher = context.getBean("customEventPublisher", WithdrawalEventPublisher.class);
		
		SavingsAccount savings = context.getBean("savings", SavingsAccount.class);
		double amount = 1524;
		if(savings.withdraw(amount)!=-1) {
			publisher.publish(amount, savings);
		}else {
			System.out.println("Unable to process transaction");
		}
		
		SalaryAccount salary = context.getBean("salary", SalaryAccount.class);
		if(salary.withdraw(amount)!=-1) {
			publisher.publish(amount, salary);
		}else {
			System.out.println("Unable to process transaction");
		}
	}
}
