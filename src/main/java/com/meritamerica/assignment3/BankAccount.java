package com.meritamerica.assignment3;

import java.io.*;
import java.text.*;
import java.util.Date;

import com.meritamerica.assignment3.MeritBank;

public class BankAccount 
{	
	/* INSTANCE VARIABLES */
	java.util.Date accountOpenedOn;
	protected long accountNumber;
	protected double balance;
	protected double interestRate;
	protected double term;
	
	BankAccount(double balance, double interestRate) //
	{
		this(MeritBank.getNextAccountNumber(), balance, interestRate, new java.util.Date());	
	}
	
	BankAccount(double balance, double interestRate, java.util.Date accountOpenedOn) //
	{
		this(MeritBank.getNextAccountNumber(), balance, interestRate, accountOpenedOn);
	}
	
	BankAccount(long accountNumber, double balance, double interestRate, java.util.Date accountOpenedOn) //
	{		
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.interestRate = interestRate;
		this.accountOpenedOn = accountOpenedOn;
	}
	
	long getAccountNumber(){return this.accountNumber;}
	
	double getBalance(){return balance;}
	
	double getInterestRate(){return interestRate;}
	
	double futureValue(int years){return balance * Math.pow((1 + interestRate), (double)years);}
	
	java.util.Date getOpenedOn(){return accountOpenedOn;}
	
	boolean withdraw(double amount)
	{		
		if(amount > 0 && amount <= getBalance())
		{
			this.balance -= amount;
			return true;
		}
		return false;
	}
	
	boolean deposit (double amount)
	{
		if(amount > 0)
		{
			this.balance += amount;
			return true;
		}
		return false;
	}
	
	static BankAccount readFromString(String accountData) throws ParseException
	{	
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		long tempAcctNum = 0;
		double tempBal = 0, tempIntRate = 0;
		Date tempOpenDate = null;
		String[] tempArr = accountData.split(",");
		try
		{
			/* "1,1000,0.0001,01/01/2020" */
			tempAcctNum = Long.parseLong(tempArr[0]);
			tempBal = Double.parseDouble(tempArr[1]);
			tempIntRate = Double.parseDouble(tempArr[2]);
			tempOpenDate = dateFormat.parse(tempArr[3]);
					
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return new BankAccount(tempAcctNum, tempBal, tempIntRate, tempOpenDate);
	}
	
	String writeToString()
	{
		String tempAcctNum = String.valueOf(accountNumber), 
				tempBalance = String.valueOf(balance), 
				tempIntRate = String.valueOf(interestRate),
				tempOpenDate = String.valueOf(accountOpenedOn);
				//tempTerm = String.valueOf(term);
		return tempAcctNum + "," +
		tempBalance + "," +
		tempIntRate + "," +
		tempOpenDate; //+ "," +
		//tempTerm;
	}
}
