package com.studytonight.community.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BankApp {

	private static AnnotationConfigApplicationContext context;
	public static void main(String[] args) {

		context = new AnnotationConfigApplicationContext(AppConfig.class);
//		Employee e = context.getBean(Manager.class);
		
		Employee e = (Employee) context.getBean("manager");
		e.doWork();
	}

}