package com.global.hr.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartUpProjectConfig implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Start Up Project Test");
		
	}

}
