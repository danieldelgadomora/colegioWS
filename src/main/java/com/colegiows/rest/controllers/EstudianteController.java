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
import com.colegiows.rest.models.EstudianteModel;
import com.colegiows.rest.services.EstudianteService;
import com.fasterxml.jackson.databind.util.JSONPObject;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/estudiante")
public class EstudianteController {
	
	
	@Autowired
	EstudianteService estudianteService;
	
	@GetMapping()
	public ArrayList<EstudianteModel> getEstudiantes(){
		return estudianteService.getEstudiantes();
	}
	
	@GetMapping(path = "/estcol/{col}")
	public List<Map<String,Object>> getEstCol(@PathVariable("col") int col){
		return estudianteService.getEstCol(col);
	}
	
	@PostMapping(path = "/addestudiante")
	public EstudianteModel addEstudiante(@RequestBody EstudianteModel estudiante) {
		return this.estudianteService.addEstudiante(estudiante);
	}
	
	@PostMapping(path = "/addmatricula/{asig}")
	public void addMatriculaNuevoEst(@RequestBody EstudianteModel estudiante, @PathVariable("asig") int asig) {
		 estudianteService.addMatriculaNuevoEst(estudiante,asig );
	}
	
	@PostMapping(path = "/addmatriculaant/{asig}/{est}")
	public void addMatriculaAntiguoEst(@PathVariable("asig") int asig, @PathVariable("est") int est) {
		 estudianteService.addMatriculaAntiguoEst(asig,est );
	}
}