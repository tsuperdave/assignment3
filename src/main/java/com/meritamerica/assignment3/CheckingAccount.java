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
	
	static CheckingAccount readFromString(String accountData) throws ParseException
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		long tempAcctNum = 0;
		double tempBal = 0, tempIntRate = 0;
		Date tempOpenDate = null;
		String[] tempArr = accountData.split(",");
		if(accountData.length() > 0)
		{
			/* "1,1000,0.0001,01/01/2020" */
			/* "a,1000,0.00015,01/01/2020" */
			tempAcctNum = Long.parseLong(tempArr[0]);
			tempBal = Double.parseDouble(tempArr[1]);
			tempIntRate = Double.parseDouble(tempArr[2]);
			tempOpenDate = dateFormat.parse((tempArr[3]));					
		}
		else
		{
			System.out.println("Checking account data format incorrect");
			throw new NumberFormatException();
		}
		return new CheckingAccount(tempAcctNum, tempBal, tempIntRate, tempOpenDate);
	}
}