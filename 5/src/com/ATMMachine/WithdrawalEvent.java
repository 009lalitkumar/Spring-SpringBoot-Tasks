package com.ATMMachine;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.ApplicationEvent;

public class WithdrawalEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;
	private final double amount;
	private final BankAccount account;
	
	public WithdrawalEvent(Object source, double amount, BankAccount account) {
		super(source);
		this.amount = amount;
		this.account = account;
	}

	@Override
	public String toString() {
		SimpleDateFormat format = new SimpleDateFormat("dd-mm-yyyy HH:MM:ss");
		return String.format("%s\n    Amount withdrawn: %.2f on %s", this.account, this.amount, format.format(new Date()));
	}

}
