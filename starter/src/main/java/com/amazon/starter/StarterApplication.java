package com.amazon.starter;

import com.amazon.starter.repository.dbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StarterApplication {

	private final dbRepository dbRepository;
	@Autowired
	public StarterApplication(dbRepository dbRepository){
		this.dbRepository = dbRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(StarterApplication.class, args);
	}

}
