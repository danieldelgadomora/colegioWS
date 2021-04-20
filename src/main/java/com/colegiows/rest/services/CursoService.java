package com.colegiows.rest.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colegiows.rest.models.CursoModel;
import com.colegiows.rest.repositories.CursoRepository;

@Service
public class CursoService {
	
	@Autowired
	CursoRepository cursoRepository;
	
	public ArrayList<CursoModel> getCursos(){
		return (ArrayList<CursoModel>) cursoRepository.findAll();
	}
	
	public List<CursoModel> getCursosCol(Long col){
		return cursoRepository.getCursosCol(col);
	}
	
	public CursoModel addCurso(CursoModel curso){
		return cursoRepository.save(curso);
	}
	
}
