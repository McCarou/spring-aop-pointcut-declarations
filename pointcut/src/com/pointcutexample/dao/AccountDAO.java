package com.pointcutexample.dao;

import org.springframework.stereotype.Component;

import com.pointcutexample.Account;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

	private String name;
	private String serviceCode;

	public void addAccount(Account theAccount, boolean vipFlag) {
		
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
		
	}

	// add a new method: findAccounts

	public List<Account> findAccounts() {

		List<Account> accountList = new ArrayList<Account>();

		// create sample accounts
		Account account1 = new Account("Joe", "Silver");
		Account account2 = new Account("Susan", "Gold");
		Account account3 = new Account("Peter", "Platinum");

		accountList.add(account1);
		accountList.add(account2);
		accountList.add(account3);

		return accountList;
	}
	
	public boolean doWork() {
		System.out.println(getClass() + ": doWork()");
		return false;
	}

	public String getName() {
		System.out.println(getClass() + ": getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + ": setName()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + ": getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": setServiceCode()");
		this.serviceCode = serviceCode;
	}
}





