package com.colegiows.rest.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.colegiows.rest.models.ColegioModel;

@Repository
public interface ColegioRepository extends CrudRepository<ColegioModel, Long>{
	
}
