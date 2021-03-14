package com.meritamerica.assignment3;

import java.io.*;
import java.text.*;

import com.meritamerica.assignment3.MeritBank;

public class BankAccount 
{	
	/* INSTANCE VARIABLES */
	java.util.Date accountOpenedOn;
	protected long accountNumber;
	protected double balance;
	protected double interestRate;
	
	BankAccount(double balance, double interestRate)
	{
		this(MeritBank.getNextAccountNumber(), balance, interestRate, new java.util.Date());	
	}
	
	BankAccount(double balance, double interestRate, java.util.Date accountOpenedOn)
	{
		this(MeritBank.getNextAccountNumber(), balance, interestRate, accountOpenedOn);
	}
	
	protected BankAccount(long accountNumber, double balance, double interestRate, java.util.Date accountOpenedOn)
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
		return null;
	}
}
