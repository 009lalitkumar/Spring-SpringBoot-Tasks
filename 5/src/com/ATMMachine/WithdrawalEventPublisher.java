package com.ATMMachine;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class WithdrawalEventPublisher  implements ApplicationEventPublisherAware {

	private ApplicationEventPublisher publisher;
	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		this.publisher = publisher;
	}
	
	public void publish(double amount, BankAccount account) {
		WithdrawalEvent event = new WithdrawalEvent(this, amount, account);
		publisher.publishEvent(event);
	}

	

}
