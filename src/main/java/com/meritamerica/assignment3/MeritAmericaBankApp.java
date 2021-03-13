package com.meritamerica.assignment3;

import java.text.*;

public class MeritAmericaBankApp {
	public static void main(String[] args) throws ParseException 
	{
		// MeritBank.readFromFile("src/test/testMeritBank_good.txt");
				
		MeritBank.readFromFile("src/test/testMeritBank_testing");									// read file
		System.out.println(MeritBank.getNextAccountNumber());										// prints next AcctNum		
		System.out.println(MeritBank.getCDOfferings().length);										// prints # of CD Offers
		
		// add CD Offer 1, term, intRate
		// add CD Offer 2
		// add CD Offer 3
		// add 2 account holders
		// lastName, mid, first, SSN of ah1
		// AH1 has 1 checking
		// checking account #1, balance, intRate, openDate
		// AH1 has 2 savings
		// savings account #2, bal, intRate, openDate
		// savings account #3, bal, intRate, openDate
		// 0 cd accounts
		// lastname, mid, first, SSN of AH2
		// AH2 has 2 checking
		// checking account #4
		// checking account #5
		// AH2 has 3 savings
		// savings #6
		// savings #7
		// savings #8
		// AH2 has 2 CD accounts
		// CD account #9, open bal, int rate, term, open date
		// CD account #10
		
		// after reading file, list AH's in ascending order based on total balances
		
		
		// -------- WEEK 3 TESTS --------- //
		/*
		CDOffering[] cdOfferings = new CDOffering[5];												// add 5 CD Offerings
		cdOfferings[0] = new CDOffering(1, 1.8);
		cdOfferings[1] = new CDOffering(2, 1.9);
		cdOfferings[2] = new CDOffering(3, 2.0);
		cdOfferings[3] = new CDOffering(5, 2.5);
		cdOfferings[4] = new CDOffering(10, 2.2);
		MeritBank.setCDOfferings(cdOfferings);
		
		AccountHolder ah1 = new AccountHolder("The", "Super", "Dave", "111-11-1111");				// Instantiate 1 new account holder, AH1
		ah1.addCheckingAccount(1000);																// add a checking account with opening bal of $1000, Savings with $10000
		ah1.addSavingsAccount(10000);																
		ah1.addCheckingAccount(5000);																// add a checking account with opening bal of $5000, savings with $50000
		ah1.addSavingsAccount(50000);																			
		ah1.addCheckingAccount(50000);																// add a checking account with opening bal of $50000, savings with $500000
		ah1.addSavingsAccount(100000);																
		ah1.addCheckingAccount(50000);																// add a checking account with opening bal of $5000, savings with $50000
		ah1.addSavingsAccount(50000);																			
		ah1.getCheckingAccounts();																	// confirm 4th checking/savings was not created
		ah1.addCDAccount(MeritBank.getBestCDOffering(500), 500);									// add best CD offering as CD account on AH1
		MeritBank.addAccountHolder(ah1);															// add AH1 to list of account holders
		
		AccountHolder ah2 = new AccountHolder("Matt", "Ricky", "Bobby", "222-22-2222");				// Instantiate AH2
		ah2.addCheckingAccount(1000);																// add a checking account with opening bal of $1000, Savings with $10000
		ah2.addSavingsAccount(10000);	
		ah2.addCDAccount(MeritBank.getSecondBestCDOffering(1000), 1000);							// add 2nd best CD offering as CD account to AH2
		MeritBank.addAccountHolder(ah2);															// add AH2 to list of account holders
		
		MeritBank.clearCDOfferings();																// clear CDs being offered by MA		
		AccountHolder ah3 = new AccountHolder("Legend", "Of", "Zelda", "333-33-3333");				// Instantiate AH3
		ah3.addCDAccount(MeritBank.getSecondBestCDOffering(3000), 3000);							// add 2nd best CD offering as CD account to AH3
		ah3.getNumberOfCDAccounts();																// confirm CD account was not created for AH3
		ah3.addCheckingAccount(1000);																// add a checking account with opening bal of $1000, Savings with $10000 for ah3
		ah3.addSavingsAccount(10000);
		MeritBank.addAccountHolder(ah3);															// add AH3 to list of account holders 
		MeritBank.totalBalances();																	// get total bal of all account holders
		*/
	}
	
}