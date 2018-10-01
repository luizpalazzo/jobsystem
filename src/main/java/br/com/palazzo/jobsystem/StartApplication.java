package br.com.palazzo.jobsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class StartApplication {
	public static void main(String[] args) {
		SpringApplication.run(StartApplication.class, args);
		System.out.println("Application Started!");		
	}

}
