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
		int tempTerm;
		int tempIntRate;
		try
		{
			/* "1,0.018" */ 
			int comma = accountHolderData.indexOf(",");
			tempTerm = Integer.parseInt(accountHolderData.substring(0, comma));
			tempIntRate = Integer.parseInt(accountHolderData.substring(comma, accountHolderData.length()));
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return new CDOffering(tempTerm, tempIntRate);
	}
	
	String writeToString()
	{
		return null;
	}

}
