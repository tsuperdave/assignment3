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
	
	static CDOffering readFromString(String accountHolderData)
	{
		int tempTerm = 0;
		double tempIntRate = 0;
		int comma = accountHolderData.indexOf(",");
		if(comma >= 0)
		{
			tempTerm = Integer.parseInt(accountHolderData.substring(0, comma));
			tempIntRate = Double.parseDouble(accountHolderData.substring(comma + 1, accountHolderData.length()));
		}else
		{
			throw new NumberFormatException();
		}
		return new CDOffering(tempTerm, tempIntRate);
		
	}
	
	String writeToString()
	{	
		return String.valueOf(this.term) + "," + String.valueOf(this.interestRate);
	}

}
