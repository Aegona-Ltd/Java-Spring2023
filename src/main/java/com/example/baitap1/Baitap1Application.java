package com.example.baitap1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//@RestController
//@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
public class Baitap1Application {

	public static void main(String[] args) {
		SpringApplication.run(Baitap1Application.class, args);
	}

}
