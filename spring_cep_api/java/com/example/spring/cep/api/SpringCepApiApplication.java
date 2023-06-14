package com.example.spring.cep.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.TimeZone;
@SpringBootApplication
@EnableFeignClients
@EnableSwagger2
public class SpringCepApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCepApiApplication.class, args);
	}

}
