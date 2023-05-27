package me.alokdev.annotation2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	
	@Bean
	public Samsung getPhone() {
		return new Samsung();
				
	}
	
	@Bean
	public CPU getCPU() {
		return new CPU();
	}
	
	@Bean
	public Xiaomi getPhone2() {
		return new Xiaomi();
	}
	
	@Bean
	public MobileProcessor getProcessor() {
		return new SnapDragon();
	}
}
