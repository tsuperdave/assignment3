package com.meritamerica.assignment3;

import java.text.*;
import java.util.*;

public class CheckingAccount extends BankAccount
{
	
	CheckingAccount(double openingBalance)
	{
		super(openingBalance, 0.0001);	
	}
	
	CheckingAccount(long accountNumber, double balance, double interestRate, java.util.Date accountOpenedOn)
	{
		super(accountNumber, balance, interestRate, accountOpenedOn);	
	}
	
	// ------------------------------------------------ FINISH ------------------------------------------------------------------//
	static CheckingAccount readFromString(String accountData) throws ParseException
	{
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
			tempOpenDate = new java.util.Date(tempArr[4]);
					
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return new CheckingAccount(tempAcctNum, tempBal, tempIntRate, tempOpenDate);
	}
}