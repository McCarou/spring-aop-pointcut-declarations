package com.pointcutexample;

import com.pointcutexample.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterThrowingDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

		List<Account> theAccounts = null;
		try {
			boolean tripWipe = true;
			theAccounts = theAccountDAO.findAccounts(tripWipe);
		} catch (Exception e) {
			System.err.println("\n\nMain Program caught an exception" + e);
		}

		// display the accounts
		System.out.println("\n\nMain Program: AfterReturningDemoApp");
		System.out.println("----");

		System.out.println(theAccounts);

		System.out.println("\n");

		// close the context
		context.close();
	}

}










