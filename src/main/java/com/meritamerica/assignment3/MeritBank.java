package com.meritamerica.assignment3;

import java.io.*;
import java.text.*;
import java.util.*;

/* Fix error with first and 2nd best CD val, add combined bals and next Acct num */

public class MeritBank 
{
	// private static final String FILE_NAME = "src/test/testMeritBank_testing";
	private static CDOffering[] listOfCDOffers;
	private static AccountHolder[] listOfAccountHolders;
	private static long nextAccountNumber = 0;
	protected static Scanner sc;
	protected static BufferedWriter bw;
	
	static void addAccountHolder(AccountHolder accountHolder)
	{
		for(int i = 0; i < listOfAccountHolders.length; i++)
		{
			if(listOfAccountHolders[i] == null)
			{
				listOfAccountHolders[i] = accountHolder;
				break;
			}
		}
	}
	
	static AccountHolder[] getAccountHolders(){return listOfAccountHolders;}
	
	static CDOffering[] getCDOfferings(){return listOfCDOffers;}
	
	static CDOffering getBestCDOffering(double depositAmount)
	{	
		if(listOfCDOffers == null) return null;
		double stored = futureValue(depositAmount, listOfCDOffers[0].getInterestRate(), listOfCDOffers[0].getTerm());
		int indexBiggest = 0;
		for(int i = 1; i < listOfCDOffers.length; i++)
		{
			double tempStored = futureValue(depositAmount, listOfCDOffers[i].getInterestRate(), listOfCDOffers[i].getTerm());
			if(tempStored > stored)
			{
				stored = tempStored;
				indexBiggest = i;
			}				
		}		
		return listOfCDOffers[indexBiggest];
	}
	
	static CDOffering getSecondBestCDOffering(double depositAmount)
	{
		if(listOfCDOffers == null) return null;
		double biggest = futureValue(depositAmount, listOfCDOffers[0].getInterestRate(), listOfCDOffers[0].getTerm());
		double secondBiggest = futureValue(depositAmount, listOfCDOffers[0].getInterestRate(), listOfCDOffers[0].getTerm());
		int indexBiggest = 0;
		int indexSecondBiggest = 0;
		for(int i = 1; i < listOfCDOffers.length; i++)
		{
			double tempStored = futureValue(depositAmount, listOfCDOffers[i].getInterestRate(), listOfCDOffers[i].getTerm());								
			if(tempStored > biggest)
			{
				indexSecondBiggest = indexBiggest;
				indexBiggest = i;			
			}
			if(tempStored > secondBiggest && tempStored != biggest)
			{
				indexSecondBiggest = i;
			}
		}		
		return listOfCDOffers[indexSecondBiggest];
	}
	
	static void clearCDOfferings(){listOfCDOffers = null;}
	
	static void setCDOfferings(CDOffering[] offerings){listOfCDOffers = offerings;}
	
	static long getNextAccountNumber(){return nextAccountNumber++;}
	
	static double totalBalances()
	{
		double total = 0;
		for(AccountHolder ah: listOfAccountHolders) 
		{
			if(ah != null)
			{
				total += ah.getCombinedBalance();
			}		
		}
		return total;
	 }
	
	public static double futureValue(double presentValue, double interestRate, int term)
	{
		return presentValue * Math.pow((1 + interestRate), term);
	}
	
	// ------------------------------------------------ FINISH ------------------------------------------------------------------//
	static BankAccount readFromFile(String accountData) throws ParseException
	{		
		try 
		{
			sc = new Scanner(new FileReader(accountData));											// get next acct num										 
			setNextAccountNumber(Long.parseLong(sc.next()));										// store next acct num
			// -- CD OFFERS -- //
			CDOffering[] newCDarr = new CDOffering[sc.nextInt()];									// set 3 cd offers
			for(int i = 0; i < newCDarr.length; i++)
			{
				newCDarr[i] = CDOffering.readFromString(sc.next());									// send to CDOffer to return 				 
			}
			setCDOfferings(newCDarr);
			
			int newNumOfAcctHolder = sc.nextInt();													// set new num of acct holders
			// -- GET ACCT HOLDER INFO AND ADD --//
			for(int i = 0; i < newNumOfAcctHolder; i++)
			{
				AccountHolder tempAcct = AccountHolder.readFromString(sc.next());					// temp store num of account holders
				int numOfCheckAccts = sc.nextInt();													// store num of checking accounts
					for(int j = 0; j < numOfCheckAccts; j++)	
					{
						tempAcct.addCheckingAccount(CheckingAccount.readFromString(sc.next()));					
					}
				int numOfSavAccts = sc.nextInt();
					for(int j = 0; j < numOfSavAccts; j++)
					{
						tempAcct.addSavingsAccount(SavingsAccount.readFromString(sc.next()));
					}
				int numOfCDAccts = sc.nextInt();
					for(int j = 0; j < numOfCDAccts; j++)
					{
						tempAcct.addCDAccount(CDAccount.readFromString(sc.next()));
					}
					
				listOfAccountHolders[i] = tempAcct;
			}	
			sc.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}		
		return null;
	}
	
	String writeToString()
	{	
		return null;
	}
	
	static AccountHolder[] sortAccountHolders(){return null;}
	
	private static void setNextAccountNumber(long nextAccountNumber){MeritBank.nextAccountNumber = nextAccountNumber;}

}
