package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@SpringBootApplication
public class TacoCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(TacoCloudApplication.class, args);
	}
	
	
	@Bean
	public DriverManagerDataSource datasource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
	     driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
	     driverManagerDataSource.setUrl("jdbc:mysql://localhost:8889/taco_spring?serverTimezone=EST5EDT");
	     driverManagerDataSource.setUsername("root");
	     driverManagerDataSource.setPassword("root");
	     
	     return driverManagerDataSource;
	}
}
