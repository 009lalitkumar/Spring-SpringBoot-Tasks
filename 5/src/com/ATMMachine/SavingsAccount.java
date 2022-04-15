package com.ATMMachine;

public class SavingsAccount extends BankAccount {

	public SavingsAccount(String accNum, String accHolder, double accBalance) {
		super(accNum, accHolder, accBalance);
	}

	@Override
	double withdraw(double amount) {
		if(amount > 3000 || amount > accBalance)
			return -1;
		accBalance -= amount;
		return accBalance;
	}

	@Override
	double deposit(double amount) {
		if(amount > 1000000)
			return -1;
		accBalance += amount;
		return accBalance;
	}

}
