package br.com.sgie.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude=HibernateJpaAutoConfiguration.class)
@ComponentScan({"br.com.sgie"})
@EntityScan("br.com.sgie")
@EnableJpaRepositories("br.com.sgie")
public class StartApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(StartApplication.class, args);
	}
	
}
