package com.meritamerica.assignment3;

import java.io.*;
import java.text.*;

public class CDOffering 
{
	private int term;
	private double interestRate;
	protected static BufferedReader br;
	
	CDOffering(int term, double interestRate)
	{
		this.term = term;
		this.interestRate = interestRate;
	}
	
	int getTerm(){return term;}
	
	double getInterestRate(){return interestRate;}
	
	static CDOffering readFromString(String accountHolderData) throws ParseException
	{
		try
		{
			br = new BufferedReader(new FileReader(accountHolderData));
			// once br hits index 2, being reading next index until reaches num of CD Accounts
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
