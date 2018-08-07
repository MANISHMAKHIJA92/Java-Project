package com.example.springBootDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan({"com.ëxample.controller, com.ëxample.DAO,com.ëxample.DTO,com.ëxample.springBootDemo"})
public class SpringBootCrudOperationsDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCrudOperationsDemoApplication.class, args);
	}
}
