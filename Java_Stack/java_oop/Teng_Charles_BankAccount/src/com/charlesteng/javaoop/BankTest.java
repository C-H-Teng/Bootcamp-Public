package com.charlesteng.javaoop;

public class BankTest {

	public static void main(String[] args) {
		BankAccount acct1 = new BankAccount();
		BankAccount acct2 = new BankAccount();

		// deposit
		acct1.depositChecking(123.45);
		acct1.depositSavings(1837.94);
		acct2.depositChecking(751.85);
		acct2.depositSavings(428.77);

		// withdraw
		acct1.withdrawChecking(100.00);
		acct1.withdrawSavings(1023.54);
		acct2.withdrawChecking(500);
		acct2.withdrawSavings(500);
		
		// get
		acct1.getTotalStats();
		System.out.println("Account number " + acct1.acctNum + "'s checking balance is: $" + acct1.getCheckingBal());
		System.out.println("Account number " + acct1.acctNum + "'s savings balance is: $" + acct1.getSavingsBal());
		System.out.println("Total in account " + acct1.acctNum + "'s is: $" + acct1.getTotalInAcct());
		System.out.println("Account number " + acct2.acctNum + "'s checking balance is: $" + acct2.getCheckingBal());
		System.out.println("Account number " + acct2.acctNum + "'s savings balance is: $" + acct2.getSavingsBal());
		System.out.println("Total in account " + acct2.acctNum + "'s is: $" + acct2.getTotalInAcct());
	}
}