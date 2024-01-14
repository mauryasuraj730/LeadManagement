package com.example.LeadManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan(value = {"com.example"})
@EnableJpaRepositories(basePackages = {"com.example.LeadManagement"})

public class LeadManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeadManagementApplication.class, args);
	}

}
