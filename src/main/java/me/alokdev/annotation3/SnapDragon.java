package me.alokdev.annotation3;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class SnapDragon implements MobileProcessor {

	@Bean
	public void process() {
		// TODO Auto-generated method stub
		System.out.println("World Best CPU");
	}

}
