package com.ATMMachine;

import org.springframework.context.ApplicationListener;

public class TransactionEventListener implements ApplicationListener<WithdrawalEvent> {

	@Override
	public void onApplicationEvent(WithdrawalEvent arg) {
		System.out.println(arg);
		
	}
}
