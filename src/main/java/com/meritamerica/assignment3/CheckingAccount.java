package com.meritamerica.assignment3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.*;
import java.util.*;

import com.meritamerica.assignment3.BankAccount;

public class CheckingAccount extends BankAccount
{
	
	CheckingAccount(double openingBalance)
	{
		super(openingBalance, 0.0001);
		
	}	
	
	static CheckingAccount readFromString(String accountData) throws ParseException
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
}