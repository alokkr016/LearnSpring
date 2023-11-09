package com.codingNinjas.Bank.Account.Registration;

/**
 * This class is an implementation of a "Account" Interface based on the
 * selection
 * done in the console for account type. You need to complete this class
 * based on the following tasks.
 * 
 * Tasks:
 * a. Create attribute amount(double)
 * b. Override the methods of Account Interface.
 * c. Build the logic for all the methods based on the description mentioned in
 * the Account Interface.
 * 
 **/

public class savingsAccount implements Account {

  double amount;

  public void init() {
    System.out.println("Current Account has been created I'm the init() method");
  }

  @Override
  public String getAccountType() {
    // TODO Auto-generated method stub
    return "Savings Account";
  }

  @Override
  public void addBalance(double balance) {
    // TODO Auto-generated method stub
    this.amount += balance;
  }

  @Override
  public double getBalance() {
    // TODO Auto-generated method stub
    return this.amount;
  }

}