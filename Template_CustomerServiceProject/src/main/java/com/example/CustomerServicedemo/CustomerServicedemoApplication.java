package com.example.CustomerServicedemo;

import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.Customers.CustomerCare;

@SpringBootApplication
public class CustomerServicedemoApplication {

	public static void main(String[] args) {

		/*
		 * You need to complete this application as mentioned in the problem
		 * statement build your own logic and perform the following tasks.
		 * 
		 * Tasks:
		 * 1. Load the beans from ApplicationContext.xml
		 * 2. Display all the departments available and get the input from user.
		 * 3. Get the message from user and store it into the respective department.
		 * 
		 */
		Scanner in = new Scanner(System.in);
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		System.out.println("Welcome to our Customer Care application");
		System.out.print("Please enter your name: ");
		String name = in.nextLine();
		System.out.println("Please select a department to connect to:");
		System.out.println("1. Payment Department\n2. Query Department\n3. Sales Department\nO. Exit");
		int deptId = in.nextInt();

		if (deptId == 1) {

			CustomerCare customerCare = (CustomerCare) context.getBean("paymentDepartment");
			customerCare.setCustomerName(name);
			customerCare.getService();
			System.out.println("How may I assist you with your query inquiry?");
			in.nextLine();
			String inquiry = in.nextLine();
			customerCare.setProblem(inquiry);
			customerCare.getProblem();

		} else if (deptId == 2) {

			CustomerCare customerCare = (CustomerCare) context.getBean("queryDepartment");
			customerCare.setCustomerName(name);
			customerCare.getService();
			System.out.println("How may I assist you with your query inquiry?");
			in.nextLine();
			String inquiry = in.nextLine();
			customerCare.setProblem(inquiry);
			customerCare.getProblem();

		} else if (deptId == 3) {

			CustomerCare customerCare = (CustomerCare) context.getBean("salesDepartment");
			customerCare.setCustomerName(name);
			customerCare.getService();
			System.out.println("How may I assist you with your query inquiry?");
			in.nextLine();
			String inquiry = in.nextLine();
			customerCare.setProblem(inquiry);
			customerCare.getProblem();

		} else if (deptId == 0) {

		}

	}
}
