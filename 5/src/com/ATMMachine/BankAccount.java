package com.ATMMachine;

public abstract class BankAccount {
	protected String accNum;
	protected String accHolder;
	protected double accBalance;

	public BankAccount(String accNum, String accHolder, double accBalance) {
		super();
		this.accNum = accNum;
		this.accHolder = accHolder;
		this.accBalance = accBalance;
	}

	public double showBalance() {
		return(accBalance);
	}
	
	abstract double withdraw(double amount);
	abstract double deposit(double amount);

	@Override
	public String toString() {
		return "BankAccount [accNum=" + accNum + ", accHolder=" + accHolder + ", accBalance=" + accBalance + "]";
	}
	
}
