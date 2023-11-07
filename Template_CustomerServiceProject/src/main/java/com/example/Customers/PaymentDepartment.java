package com.example.Customers;

import java.util.Random;

public class PaymentDepartment implements CustomerCare {

  private String department = "Payment Department";
  private String customerName;
  private String issue;
  private double refId;

  @Override
  public String getDepartment() {
    return department;
  }

  @Override
  public void getService() {
    System.out.println("Welcome to " + department + customerName);
  }

  @Override
  public void setCustomerName(String name) {
    this.customerName = name;
  }

  @Override
  public void setProblem(String problem) {
    this.issue = problem;
    this.refId = new Random().nextDouble() * 1000;
  }

  @Override
  public void getProblem() {
    System.out.println(
        "Dear " + customerName + ", your issue " + issue + " has been recorded. Your reference ID is: " + refId);
  }
}
