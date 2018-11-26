package br.com.palazzo.jobsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EnableScheduling
public class StartApplication extends SpringBootServletInitializer{
	
	/*
	public static void main(String[] args) {
		SpringApplication.run(StartApplication.class, args);
		System.out.println("Application Started!");		
	}
	**/
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(StartApplication.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(StartApplication.class, args);
    }


}
