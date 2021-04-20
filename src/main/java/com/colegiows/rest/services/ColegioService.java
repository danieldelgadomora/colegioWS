package com.colegiows.rest.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colegiows.rest.models.ColegioModel;
import com.colegiows.rest.repositories.ColegioRepository;

@Service
public class ColegioService {
	
	@Autowired
	ColegioRepository colegioRepository;
	
	public Optional<ColegioModel> getColegios(Long id){
		return colegioRepository.findById(id);
	}
	
	public ColegioModel addColegio(ColegioModel colegio){
		return colegioRepository.save(colegio);
	}
}
