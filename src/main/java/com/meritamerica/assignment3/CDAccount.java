package com.meritamerica.assignment3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.*;
import java.util.*;
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
		try
		{
			br = new BufferedReader(new FileReader(accountData));
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
