package me.alokdev.annotation2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class);
//		Samsung s7 = factory.getBean(Samsung.class);
//		s7.config();
//		
//		CPU cp = factory.getBean(CPU.class);
//		cp.fetchCPU(); 
		
		
		Xiaomi sprime = factory.getBean(Xiaomi.class);
		sprime.config();
	}
}
