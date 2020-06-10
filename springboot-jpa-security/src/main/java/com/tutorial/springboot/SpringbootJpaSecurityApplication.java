package com.tutorial.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.tutorial.springboot.security.model.UserRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses= UserRepository.class)
public class SpringbootJpaSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaSecurityApplication.class, args);
	}

}
