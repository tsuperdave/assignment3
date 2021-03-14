package com.meritamerica.assignment3;

import java.text.*;
import java.util.Date;

// add Override for withdraw/deposit so if term < startDate, return false

public class CDAccount extends BankAccount
{
	CDOffering offering;
	java.util.Date startDate;

	CDAccount(CDOffering offering, double balance)
	{
		super(balance, offering.getInterestRate());
		this.offering = offering;
		startDate = new java.util.Date();
	}
	
	CDAccount(double balance, double interestRate, Date accountOpenedOn, double term)
	{
		super(MeritBank.getNextAccountNumber(), balance, interestRate, accountOpenedOn, term);
	}
	
	
	int getTerm()
	{
		return this.offering.getTerm();
	}
	
	java.util.Date getStartDate()
	{
		return startDate;
	}
	
	static CDAccount readFromString(String accountData) throws ParseException
	{
		long tempAcctNum = 0;
		double tempBal = 0, tempIntRate = 0, tempTerm = 0;
		Date tempOpenDate = null;
		String[] tempArr = accountData.split(",");
		try
		{
			/* "9,5000,0.02,01/01/2020,5" */
			tempAcctNum = Long.parseLong(tempArr[0]);
			tempBal = Double.parseDouble(tempArr[1]);
			tempIntRate = Double.parseDouble(tempArr[2]);
			tempOpenDate = new java.util.Date(tempArr[3]);
			tempTerm = Double.parseDouble(tempArr[4]);
					
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return new CDAccount(tempBal, tempIntRate, tempOpenDate, tempTerm);
	}
	
	String writeToString()
	{
		String tempAcctNum = String.valueOf(MeritBank.getNextAccountNumber()), 
				tempBal = String.valueOf(balance), 
				tempIntRate = String.valueOf(offering.getInterestRate()), 
				tempOpenDate = String.valueOf(startDate),
				tempTerm = String.valueOf(getTerm());
		
		return tempAcctNum + "," +
		tempBal + "," +
		tempIntRate + "," +
		tempOpenDate + "," +
		tempTerm;		
	}
	
}
