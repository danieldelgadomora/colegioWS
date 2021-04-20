package com.colegiows.rest.services;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colegiows.rest.models.AsignaturaModel;
import com.colegiows.rest.models.CursoModel;
import com.colegiows.rest.repositories.AsignaturaRepository;

@Service
public class AsignaturaService{
	
	@Autowired
	AsignaturaRepository asignaturaRepository;
	
	public List<Map<String,Object>> getAsignaturasCol(int col) {
		List<Map<String,Object>> list = asignaturaRepository.getAsignaturasCol(col);
		return list;
	}
	
	public List<Map<String,Object>> getCursos(int prof) {
		List<Map<String,Object>> list = asignaturaRepository.getCursos(prof);
		return list;
	}
	
	public AsignaturaModel addAsignatura(AsignaturaModel asignatura){
		return asignaturaRepository.save(asignatura);
	}
	
	
}
