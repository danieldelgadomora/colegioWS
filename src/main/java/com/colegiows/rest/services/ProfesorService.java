package com.colegiows.rest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.colegiows.rest.models.ProfesorModel;
import com.colegiows.rest.repositories.ProfesorRepository;

@Service
public class ProfesorService {
	
	@Autowired
	ProfesorRepository profesorRepository;
	
	public ArrayList<ProfesorModel> getProfesores(){
		return (ArrayList<ProfesorModel>) profesorRepository.findAll();
	}
	
	public List<Map<String,Object>> getProfesoresCol(int col) {
		List<Map<String,Object>> list = profesorRepository.getProfesores(col);
		return list;
	}
	
	public ProfesorModel addProfesor(ProfesorModel profesor){
		return profesorRepository.save(profesor);
	}

}
