package com.example.gcp-sql-proxy.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan("com.example.gcp-sql-proxy.*")
@EntityScan("com.example.gcp-sql-proxy.*")
@ComponentScan(basePackages = { "my.package.base.*" })
@EnableJpaRepositories("com.example.gcp-sql-proxy.*")
@SpringBootApplication
public class ProductApplication {

	public static void main(String[] args) {

		SpringApplication.run(ProductApplication.class, args);
	}

}
