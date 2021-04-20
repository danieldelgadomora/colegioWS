package com.colegiows.rest.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.colegiows.rest.models.ColegioModel;
import com.colegiows.rest.services.ColegioService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/colegio")
public class ColegioController {
	@Autowired
	ColegioService colegioService;
	
	@GetMapping(path = "/{id}")
	public Optional<ColegioModel> getColegio(@PathVariable("id") Long id){
		return colegioService.getColegios(id);
	}
	
	@PostMapping()
	public ColegioModel addColegio(@RequestBody ColegioModel colegio) {
		return this.colegioService.addColegio(colegio);
	}
}
