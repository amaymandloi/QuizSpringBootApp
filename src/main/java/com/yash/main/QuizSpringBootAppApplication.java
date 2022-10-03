package com.yash.main;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.yash.*")
@ImportResource("classpath:applicationContext.xml")
@PropertySource("classpath:db.properties")
@EnableJpaRepositories("com.yash.*")
//@ComponentScan("com.yash.*")
public class QuizSpringBootAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizSpringBootAppApplication.class, args);
		
	}

}
