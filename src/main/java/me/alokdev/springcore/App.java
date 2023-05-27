package me.alokdev.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("me//alokdev//springcore//config.xml");
		
		Vehicle car = (Vehicle) context.getBean("vehicle");
		car.drive();
		
		Engine e = (Engine) context.getBean("engine");
		System.out.println(e);

		Price p = (Price) context.getBean("price");
		System.out.println(p);
		
		Tyre t = (Tyre)context.getBean("tyre");
		System.out.println(t);
		
		
	}
}
