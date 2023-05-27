package com.studytonight.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Hello {
	
	public static void main(String[] args) {
 
		// loading the Bean and XML definitions from the given XML file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com//studytonight//example//applicationContext.xml");
		HelloWorldService obj = context.getBean(HelloWorldService.class);
//		HelloWorldService obj = (HelloWorldService) context.getBean("helloWorldService"); //another way
		obj.hello();
		context.close();
	}
}