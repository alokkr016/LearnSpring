package com.codingNinjas.Bank.Account.Registration;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class BankAccountRegistrationApplication {

	public static void openAccount(String acountType, int balance, myUser user, Account account) {

		account.addBalance(balance);
		user.addAccount(account);
	}

	public static void main(String[] args) {

		/*
		 * You need to complete this application as mentioned in the problem
		 * statement build your own logic and perform the following tasks.
		 * 
		 * 1. Fetch context from ApplicationContext.xml and initiate scanner.
		 * 2. Get user details from console.
		 * 3. Get account details from user and add them to the account list.
		 * 4. Display the list of accounts with their reference ids.
		 */
		Scanner in = new Scanner(System.in);
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		System.out.println("Welcome to Account Registration Application!");
		System.out.println("Please enter Your name?");
		String name = in.nextLine();
		myUser user = (myUser) context.getBean("myUser");
		user.setUserDetails(name);
		System.out.println("Do you want to add account\n" + //
				"1. Yes\n" + //
				"2. No");
		int openStatus = in.nextInt();
		while (true) {

			if (openStatus == 1) {
				System.out.println("Please select the account type\n" + //
						"1. Current\n" + //
						"2. Savings");
				int accountType = in.nextInt();
				if (accountType == 1) {
					Account account = (Account) context.getBean("currentAccount");
					System.out.println("Enter the opening balance");
					int balance = in.nextInt();
					openAccount("Current", balance, user, account);
				} else if (accountType == 2) {
					Account account = (Account) context.getBean("savingsAccount");
					System.out.println("Enter the opening balance");
					int balance = in.nextInt();
					openAccount("Savings", balance, user, account);
				}

			}

			System.out.println("Do you want to add more accounts\n" + //
					"1. Yes\n" + //
					"2. No");
			int moreAccount = in.nextInt();
			if (moreAccount == 1) {
				continue;
			} else if (moreAccount == 2) {
				break;
			}
		}
		List<Account> accounts =  user.getAllAccounts();
		System.out.println("Hi "+user.getName()+", here is the list of your accounts:");
		for(Account account : accounts){
			System.out.println(account.getAccountType() + " : opening balance - " + account.getBalance() + " Reference Id @" + account.hashCode() );
		}

	}

}
