package com.meritamerica.assignment3;

import java.text.*;

public class CDOffering 
{
	private int term;
	private double interestRate;
	
	CDOffering(int term, double interestRate)
	{
		this.term = term;
		this.interestRate = interestRate;
	}
	
	int getTerm(){return term;}
	
	double getInterestRate(){return interestRate;}
	
	// ------------------------------------------------ FINISH ------------------------------------------------------------------//
	static CDOffering readFromString(String accountHolderData) throws ParseException
	{
		int tempTerm = 0;
		double tempIntRate = 0;
		try
		{ 
			int comma = accountHolderData.indexOf(",");
			tempTerm = Integer.parseInt(accountHolderData.substring(0, comma));
			tempIntRate = Double.parseDouble(accountHolderData.substring(comma + 1, accountHolderData.length()));
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}		
		return new CDOffering(tempTerm, tempIntRate);
	}
	
	String writeToString()
	{	
		return String.valueOf(this.term) + "," + String.valueOf(this.interestRate);
	}

}
