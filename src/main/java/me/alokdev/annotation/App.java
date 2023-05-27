package me.alokdev.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("me//alokdev//annotation//config.xml");
		Vehicle car = (Vehicle) context.getBean("bike");
		car.drive();
//		Tyre t = (Tyre)context.getBean("tyre");
//		System.out.println(t);
	}
}
