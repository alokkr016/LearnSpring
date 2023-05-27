package me.alokdev.autowiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("me//alokdev//autowiring//config.xml");

		TextEditor te = (TextEditor) context.getBean("texteditor");
		te.spellCheck();

		Employee emp = (Employee) context.getBean("emp");
		System.out.println(emp);
	}

}
