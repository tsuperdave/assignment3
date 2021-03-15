package com.meritamerica.assignment3;

import java.text.*;
import java.util.Date;

// add Override for withdraw/deposit so if term < startDate, return false

public class CDAccount extends BankAccount
{
	private int term;
	java.util.Date startDate;
	
	CDAccount(CDOffering offering, double balance)
	{
		super(balance, offering.getInterestRate(), new Date());
		this.term = offering.getTerm();		
	}
	
	CDAccount(long accountNumber, double balance, double interestRate, Date accountOpenedOn, int term)
	{
		super(accountNumber, balance, interestRate, accountOpenedOn);
		this.term = term;
	}
	
	int getTerm(){return this.term;}
	
	@Override
	boolean withdraw(double amount)
	{
		if(amount <= getBalance()  && amount > 0 && new Date().getYear() > getOpenedOn().getYear() + getTerm())
		{
			this.balance -= amount;
			return true;
		}
		System.out.println("Cannot withdraw");
		return false;		
	}
	
	@Override
	boolean deposit (double amount)
	{
		if(amount > 0 && new Date().getYear() > getOpenedOn().getYear() + getTerm())
		{
			this.balance += amount;
			return true;
		}
		return false;		
	}	
	
	double futureValue()
	{
		return getBalance() * Math.pow((1 + getInterestRate()), term);
	}
	
	static CDAccount readFromString(String accountData) throws ParseException
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		long tempAcctNum = 0;
		double tempBal = 0, tempIntRate = 0;
		int tempTerm = 0;
		Date tempOpenDate = null;
		String[] tempArr = accountData.split(",");
		if(accountData.length() > 0)
		{
			/* "9,5000,0.02,01/01/2020,5" */
			tempAcctNum = Long.parseLong(tempArr[0]);
			tempBal = Double.parseDouble(tempArr[1]);
			tempIntRate = Double.parseDouble(tempArr[2]);
			tempOpenDate = dateFormat.parse(tempArr[3]);
			tempTerm = Integer.parseInt(tempArr[4]);					
		}
		else
		{
			throw new NumberFormatException();
		}
		return new CDAccount(tempAcctNum, tempBal, tempIntRate, tempOpenDate, tempTerm);
	}
	
	String writeToString()
	{
		String tempAcctNum = String.valueOf(super.getAccountNumber()), 
				tempBal = String.valueOf(this.balance), 
				tempIntRate = String.valueOf(getInterestRate()), 
				tempOpenDate = String.valueOf(this.startDate),
				tempTerm = String.valueOf(this.getTerm());
		
		return tempAcctNum + "," +
		tempBal + "," +
		tempIntRate + "," +
		tempOpenDate + "," +
		tempTerm;		
	}
	
}
