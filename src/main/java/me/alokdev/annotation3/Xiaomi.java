package me.alokdev.annotation3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class Xiaomi {
	
	@Autowired
	MobileProcessor cpu;

	public MobileProcessor getCpu() {
		return cpu;
	}

	public void setCpu(MobileProcessor cpu) {
		this.cpu = cpu;
	}
	
	 
	public void config() {
		System.out.println("Octa core 8GB Ram");
		cpu.process();
	}
	
}
