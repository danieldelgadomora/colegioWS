package com.colegiows.rest.controllers;

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

import com.colegiows.rest.models.AsignaturaModel;
import com.colegiows.rest.models.CursoModel;
import com.colegiows.rest.services.AsignaturaService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/asignatura")
public class AsignaturaController {
	
	@Autowired
	AsignaturaService asignaturaService;
	
	@GetMapping(path = "asignatuascol/{col}")
	public List<Map<String,Object>> getAsignaturasCol(@PathVariable("col") int col){
		return this.asignaturaService.getAsignaturasCol(col);
	}
	
	@GetMapping(path = "profesor/{prof}")
	public List<Map<String,Object>> getCurso(@PathVariable("prof") int prof){
		return this.asignaturaService.getCursos(prof);
	}
	
	@PostMapping()
	public AsignaturaModel addAsignatura(@RequestBody AsignaturaModel asignatura) {
		return this.asignaturaService.addAsignatura(asignatura);
	}

}
