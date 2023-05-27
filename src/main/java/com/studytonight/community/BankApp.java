package com.studytonight.community;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BankApp {

	private static ApplicationContext context;
	public static void main(String[] args) {

		context = new ClassPathXmlApplicationContext("com//studytonight//community//applicationContext.xml");
		Employee e = (Employee) context.getBean("accountant");
		e.doWork();
	}

}