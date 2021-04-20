package com.colegiows.rest.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.colegiows.rest.models.CursoModel;
import com.colegiows.rest.services.CursoService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/curso")
public class CursoController {
	
	@Autowired
	CursoService cursoService;
	
	@GetMapping()
	public ArrayList<CursoModel> getCursos(){
		return cursoService.getCursos();
	}
	
	@GetMapping(path ="/cursoscol/{col}")
	public List<CursoModel> getCursosCol(@PathVariable("col") Long col){
		return cursoService.getCursosCol(col);
	}
	
	
	@PostMapping()
	public CursoModel addCurso(@RequestBody CursoModel curso) {
		return this.cursoService.addCurso(curso);
	}
}
