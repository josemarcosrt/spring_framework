package com.jpa.spring.one.to.many;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class OneToManyApplication {

	public static void main(String[] args) {
		SpringApplication.run(OneToManyApplication.class, args);
	}

}
