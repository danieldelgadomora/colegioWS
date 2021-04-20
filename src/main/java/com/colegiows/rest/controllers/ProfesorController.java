package com.colegiows.rest.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.colegiows.rest.models.ProfesorModel;
import com.colegiows.rest.services.ProfesorService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/profesor")
public class ProfesorController {
	@Autowired
	ProfesorService profesorService;
	
	@GetMapping()
	public ArrayList<ProfesorModel> getProfesor(){
		return profesorService.getProfesores();
	}
	
	@GetMapping(path = "/profesorescol/{col}")
	public List<Map<String,Object>> getProfesoresCol(@PathVariable("col") int col){
		return profesorService.getProfesoresCol(col);
	}
	
	@PostMapping()
	public ProfesorModel addProfesor(@RequestBody ProfesorModel profesor) {
		return this.profesorService.addProfesor(profesor);
	}
	
}
