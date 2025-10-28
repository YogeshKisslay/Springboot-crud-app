package com.CRUDproject.em_projectCRUD;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//IOC automatically manages the objects and their dependencies through dependency injection
//in springboot object are called beans
@SpringBootApplication
public class EmProjectCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmProjectCrudApplication.class, args);
	}

}


// NOTE:we are just making backend using springboot here and for frontend we can use any framework like react,angular etc. Here we will make rest api using springboot which can be consumed by any frontend framework.