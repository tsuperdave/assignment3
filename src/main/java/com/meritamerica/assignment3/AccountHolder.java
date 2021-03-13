package com.meritamerica.assignment3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.ParseException;

import com.meritamerica.assignment3.CDAccount;
import com.meritamerica.assignment3.CDOffering;
import com.meritamerica.assignment3.CheckingAccount;
import com.meritamerica.assignment3.MeritBank;
import com.meritamerica.assignment3.SavingsAccount;

public class AccountHolder implements Comparable<AccountHolder>
{
	/*INSTANCE VARIABLES*/
	
	private static final double BALANCE_LIMIT = 250000;
	private static int balance;
	private String firstName;
	private String middleName;
	private String lastName;
	private String ssn;
	protected static BufferedReader br;
	private CheckingAccount[] checkingAccountList = new CheckingAccount[10];
	private SavingsAccount[] savingsAccountList = new SavingsAccount[10];
	private CDAccount[] cdAccountList = new CDAccount[10];
	
		
	/*METHODS*/	
	AccountHolder(
			String firstName,
			String middleName,
			String lastName,
			String ssn			
			)
	{
		this.firstName = firstName;		
		this.middleName = middleName;
		this.lastName = lastName;
		this.ssn = ssn;
		
	}
		
	/* GETTERS/SETTERS */
	String getFirstName(){return firstName;}
	void setFirstName(String firstName){this.firstName = firstName;}
	
	String getMiddleName(){return middleName;}
	void setMiddleName(String middleName){this.middleName = middleName;}
	
	String getLastName(){return lastName;}
	void setLastName(String lastName){this.lastName = lastName;}
	
	String getSSN(){return ssn;}
	void setSSN(String ssn){this.ssn = ssn;}
	
	double getCombinedBalance(){return getCheckingBalance() + getSavingsBalance() + getCDBalance();}
	
	/* CHECKING ACCOUNT */
	CheckingAccount addCheckingAccount(double openingBalance)
	{
		if((openingBalance + (getCombinedBalance() - getCDBalance()) < BALANCE_LIMIT))
		{
			return addCheckingAccount(new CheckingAccount(openingBalance));
		}		
		return null;
	}
	
	CheckingAccount addCheckingAccount(CheckingAccount checkingAccount)
	{
		if((checkingAccount.getBalance() + (getCombinedBalance() - getCDBalance()) < BALANCE_LIMIT))
		{
			for(int i = 0; i < checkingAccountList.length; i++)
			{
				if(checkingAccountList[i] == null)
				{
					checkingAccountList[i] = checkingAccount;
					break;
				}
			}
		}
		return checkingAccount;
	}
	
	CheckingAccount[] getCheckingAccounts() 
	{
		return checkingAccountList;
	}
	
	int getNumberOfCheckingAccounts()
	{
		int numOfAccounts = 0;
		for(CheckingAccount i: checkingAccountList)
		{
			if(i != null)
			{
				numOfAccounts++;
			}
		}
		return numOfAccounts;
	}
	
	double getCheckingBalance()
	{
		double sum = 0;
		for(int i = 0; i < checkingAccountList.length + 1; i++)
		{
			if(checkingAccountList[i] == null)
			{
				break;
			}
			sum += checkingAccountList[i].getBalance();
		}
		return sum;
	}
	
	/* SAVINGS ACCOUNT */
	SavingsAccount addSavingsAccount(double openingBalance)
	{
		if((openingBalance + (getCombinedBalance() - getCDBalance()) < BALANCE_LIMIT))
				{
					return addSavingsAccount(new SavingsAccount(openingBalance));
				}		
		return null;
	}	
	
	SavingsAccount addSavingsAccount(SavingsAccount savingsAccount)
	{
		if((savingsAccount.getBalance() + (getCombinedBalance() - getCDBalance()) < BALANCE_LIMIT))
		{
			for(int i = 0; i < savingsAccountList.length; i++)
			{
				if(savingsAccountList[i] == null)
				{
					savingsAccountList[i] = savingsAccount;
					break;
				}
			}
		}
		return savingsAccount;
	}
	
	SavingsAccount[] getSavingsAccounts()
	{
		return savingsAccountList;
	}
	
	int getNumberOfSavingsAccounts()
	{
		int numOfAccounts = 0;
		for(SavingsAccount i: savingsAccountList)
		{
			if(i != null)
			{
				numOfAccounts++;
			}
		}
		return numOfAccounts;
	}
	
	double getSavingsBalance()
	{
		double sum = 0;
		for(int i = 0; i < savingsAccountList.length + 1; i++)
		{
			if(savingsAccountList[i] == null)
			{
				break;
			}
			sum += savingsAccountList[i].getBalance();
		}
		return sum;
	}
	
	/* CD ACCOUNT */
	CDAccount addCDAccount(CDOffering offering, double openingBalance)
	{
		if(MeritBank.getCDOfferings() == null)
		{
			return null;
		} else {
		return addCDAccount(new CDAccount(offering, openingBalance));
		}
	}
	
	CDAccount addCDAccount(CDAccount cdAccount)
	{
		if(cdAccountList == null)
		{
			return null;
		}
		for(int i = 0; i < cdAccountList.length; i++)
		{
			if(cdAccountList[i] == null)
			{
				cdAccountList[i] = cdAccount;
				break;
			}
		}
		return cdAccount;
	}
	
	CDAccount[] getCDAccounts()
	{
		return cdAccountList;
	}
	
	int getNumberOfCDAccounts()
	{
		int numOfAccounts = 0;
		for(CDAccount i: cdAccountList)
		{
			if(i != null)
			{
				numOfAccounts++;
			}			
		}
		return numOfAccounts;
	}
	
	double getCDBalance()
	{
		double sum = 0;
		for(int i = 0; i < cdAccountList.length + 1; i++)
		{
			if(cdAccountList[i] == null)
			{
				break;
			}
			sum += cdAccountList[i].getBalance();
		}
		return sum;
	}
	
	static SavingsAccount readFromString(String accountHolderData) throws ParseException
	{
		try
		{
			br = new BufferedReader(new FileReader(accountHolderData));
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public int compareTo(AccountHolder obj) {
		int compareBalance = (int)obj.getCombinedBalance();
		return this.balance = compareBalance;
	}
}