package com.colegiows.rest.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.colegiows.rest.models.CursoModel;

@Repository
public interface CursoRepository extends CrudRepository<CursoModel, Long>{
	
	@Query(value="select c from CursoModel c where c.colegio.id = (?1)")
	List<CursoModel> getCursosCol(Long col);

}
