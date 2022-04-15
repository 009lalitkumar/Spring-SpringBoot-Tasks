package com.ATMMachine;

public class SalaryAccount extends BankAccount {

	public SalaryAccount(String accNum, String accHolder, double accBalance) {
		super(accNum, accHolder, accBalance);
	}

	@Override
	double withdraw(double amount) {
		if(amount > 100000 || amount > accBalance)
			return -1;
		accBalance -= amount;
		return accBalance;
	}

	@Override
	double deposit(double amount) {
		accBalance += amount;
		return accBalance;
	}

}
