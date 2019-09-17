package com.skcc.cnaps.role;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class RoleServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(RoleServiceApplication.class, args);
	}
}
