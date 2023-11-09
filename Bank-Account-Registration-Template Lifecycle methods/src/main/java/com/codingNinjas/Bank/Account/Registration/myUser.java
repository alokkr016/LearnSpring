package com.codingNinjas.Bank.Account.Registration;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is an implementation of a User Interface based on the selection
 * done in the console for user information.You need to complete this class
 * based on the following tasks.
 * 
 * a. Adding common attributes:
 * 1. String name
 * 2. List<Account> accountList.
 * b. Override the methods of User Interface.
 * c. Build the logic for all the methods based on the description mentioned in
 * the Account Interface.
 * 
 **/

public class myUser implements User {

  public void init(){
System.out.println("User bean has been instantiated and I'm the init() method");
  }

  public void destroy(){
    System.out.println("User bean has been closed and I'm the destroy) method");
  }
String name;
List<Account> accountList = new ArrayList<>();

  @Override
  public void setUserDetails(String name) {
  
    this.name = name;
  }

  @Override
  public void addAccount(Account account) {
    // TODO Auto-generated method stub
   accountList.add(account);
  }

  @Override
  public List<Account> getAllAccounts() {
    // TODO Auto-generated method stub
   return this.accountList;
  }

  @Override
  public String getName() {
    // TODO Auto-generated method stub
    return this.name;
  }

}
