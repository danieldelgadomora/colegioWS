package com.colegiows.rest.repositories;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.colegiows.rest.models.EstudianteModel;

@Repository
public interface EstudianteRepository extends CrudRepository<EstudianteModel, Long>{
	
	@Query(value="select "
			+ "distinct "
			+ "e.id, "
			+ "e.nombre"
			+ " from "
			+ "estudiante e "
			+ "join asignatura_estudiante ae on ae.estudiante_id = e.id "
			+ "join asignatura a on a.id = ae.asignatura_id "
			+ "join curso c on c.id = a.curso "
			+ "where c.colegio = (?1) "
			+ "order by e.nombre",nativeQuery = true)
	List<Map<String,Object>> getEstudiantes(int col);

}