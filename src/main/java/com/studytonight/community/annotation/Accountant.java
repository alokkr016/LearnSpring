package com.studytonight.community.annotation;

import org.springframework.stereotype.Component;

@Component
public class Accountant implements Employee{
	
	public void doWork() {
		
		System.out.println("Audit the accounts...");
	}
}