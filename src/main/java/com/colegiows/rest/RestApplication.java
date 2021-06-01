package com.colegiows.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.colegiows.rest.models.ColegioModel;
import com.colegiows.rest.repositories.ColegioRepository;


@SpringBootApplication
public class RestApplication {
	
	@Autowired
	ColegioRepository colegioRepository;

	public static void main(String[] args) {
		SpringApplication.run(RestApplication.class, args);
	}

}
