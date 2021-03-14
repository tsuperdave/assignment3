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
	
	BankAccount(double balance, double interestRate)
	{
		this(MeritBank.getNextAccountNumber(), balance, interestRate, new java.util.Date());	
	}
	
	BankAccount(double balance, double interestRate, java.util.Date accountOpenedOn)
	{
		this(MeritBank.getNextAccountNumber(), balance, interestRate, accountOpenedOn);
	}
	
	BankAccount(double balance, double interestRate, Date accountOpenedOn, double term)
	{
		this(MeritBank.getNextAccountNumber(), balance, interestRate, accountOpenedOn, term);
	}
	
	protected BankAccount(long accountNumber, double balance, double interestRate, java.util.Date accountOpenedOn)
	{		
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.interestRate = interestRate;
		this.accountOpenedOn = accountOpenedOn;
	}
	
	protected BankAccount(long accountNumber, double balance, double interestRate, java.util.Date accountOpenedOn, double term)
	{		
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.interestRate = interestRate;
		this.accountOpenedOn = accountOpenedOn;
		this.term = term;
	}
	
	long getAccountNumber(){return this.accountNumber;}
	
	double getBalance(){return balance;}
	
	double getInterestRate(){return interestRate;}
	
	double futureValue(int years){return balance * Math.pow((1 + interestRate), (double)years);}
	
	java.util.Date getOpenedOn(){return accountOpenedOn;}
	
	boolean withdraw(double amount)
	{
		if(amount >= balance)
		{
			this.balance -= amount;
			return true;
		}
		return false;
	}
	
	boolean deposit (double amount)
	{
		if(amount < 0)
		{
			this.balance += amount;
			return true;
		}
		return false;
	}
	

	// ------------------------------------------------ FINISH ------------------------------------------------------------------//
	static BankAccount readFromString(String accountData) throws ParseException
	{
		try 
		{
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	String writeToString()
	{
		String tempAcctNum = String.valueOf(accountNumber), 
				tempBalance = String.valueOf(balance), 
				tempIntRate = String.valueOf(interestRate),
				tempOpenDate = String.valueOf(accountOpenedOn),
				tempTerm = String.valueOf(term);
		return tempAcctNum + "," +
		tempBalance + "," +
		tempIntRate + "," +
		tempOpenDate + "," +
		tempTerm;
	}
}
