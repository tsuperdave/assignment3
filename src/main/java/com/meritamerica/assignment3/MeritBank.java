package com.meritamerica.assignment3;

import java.io.*;
import java.text.*;
import java.util.*;

/* Fix error with first and 2nd best CD val, add combined bals and next Acct num */

public class MeritBank 
{
	// private static final String FILE_NAME = "src/test/testMeritBank_testing";
	private static CDOffering[] listOfCDOffers;
	private static AccountHolder[] listOfAccountHolders = new AccountHolder[10];
	private static long nextAccountNumber = 0;
	protected static BufferedReader br;
	protected static BufferedWriter bw;
	protected static ArrayList<String> accountInfo;
	
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
		listOfAccountHolders = new AccountHolder[10];
		try 
		{
			br = new BufferedReader(new FileReader(accountData));						// instantiate new BReader
			accountInfo = new ArrayList<>();											// instantiate new LList
			while(true)
			{
				String line = br.readLine();											// loop and read/add lines to ArrList
				if(line == null) break;													// if no more lines, break loop
				
				accountInfo.add(line);
						
			}
			// System.out.println(accountInfo);											// PRINT LIST
			
			// --- gets first line as next accnt num --- //
			String nextAccountNumAsStr = accountInfo.get(0);							// get first line of file, will be nextAcnt num
			nextAccountNumber = Integer.parseInt(nextAccountNumAsStr);					// set nextAcctNum, parse line 1 from List and set to accnt num
			
			// --- gets 2nd line as num of cd offers --- //
			int getNumOfCDOffers = Integer.parseInt(accountInfo.get(1));
			// System.out.println(getNumOfCDOffers);
			CDOffering[] newListOfCDOffers = new CDOffering[getNumOfCDOffers];
			setCDOfferings(newListOfCDOffers);
			//---add for loop to add the i num of lines IE getNumOfCDOffers after this line
			//---add i num of lines to CD Offers array
			
			// System.out.println(line);				
			// System.out.println(accountInfo);
			
			// --- //
			
			br.close();
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
