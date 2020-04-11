package com.example.jpaSqlSecurityWeb;

import com.example.jpaSqlSecurityWeb.UserRepo.UserRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepo.class)
public class JpaSqlSecurityWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaSqlSecurityWebApplication.class, args);
	}

}
