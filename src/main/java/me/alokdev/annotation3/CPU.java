package me.alokdev.annotation3;

import org.springframework.stereotype.Component;

@Component
public class CPU {
	public void fetchCPU() {
		System.out.println("I have 2 cpu");
	}
}
