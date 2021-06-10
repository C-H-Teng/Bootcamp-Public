package com.charlesteng.javaoop;
import java.util.Random;

public class BankAccount {
	protected String acctNum = "";
	private double checkingBal;
	private double savingsBal;
	
	private static int numOfAccts = 0;
	private static double totalDeposited = 0;
	
	public BankAccount() {
		numOfAccts++;
		this.acctNum = acctGenerator();
		this.checkingBal = 0;
		this.savingsBal = 0;
	}


	// methods
	private String acctGenerator() {
		Random num = new Random();
		
		while(acctNum.length() != 10) {
			acctNum = acctNum + num.nextInt(10);
		}
		return acctNum;
	}
	
	
	public void getTotalStats() {
		System.out.println("Total accounts made: " + numOfAccts);
		System.out.println("Total cash deposited: " + totalDeposited);
	}
	
	
	public double getTotalInAcct() {
		return this.checkingBal + this.savingsBal;
	}


	public double getCheckingBal() {
		return this.checkingBal;
	}

	public void depositChecking(double money) {
		this.checkingBal += money;
		totalDeposited += money;
	}

	public void withdrawChecking(double money) {
		if(this.checkingBal >= money) {
			this.checkingBal -= money;
			totalDeposited -= money;
		} else {
			System.out.println("You do not have enough money to withdraw from checking.");
		}
	}



	public double getSavingsBal() {
		return this.savingsBal;
	}

	public void depositSavings(double money) {
		this.savingsBal += money;
		totalDeposited += money;
	}

	public void withdrawSavings(double money) {
		if(this.savingsBal >= money) {
			this.savingsBal -= money;
			totalDeposited -= money;
		} else {
			System.out.println("You do not have enough money to withdraw from savings.");
		}
	}
}
