package com.colegiows.rest.repositories;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.colegiows.rest.models.AsignaturaModel;


public interface AsignaturaRepository extends CrudRepository<AsignaturaModel, Long>{
	
	@Query(value="select "
			+ "a.id id_asignatura, "
			+ "a.nombre || ' ' || c.grado || ' ' || c.salon curso, "
			+ "from "
			+ "asignatura a "
			+ "join curso c on a.curso = c.id "
			+ "join colegio col on col.id = c.colegio "
			+ "where "
			+ "col.id = (?1) "
			+ "group by "
			+ "a.nombre, "
			+ "c.grado, "
			+ "c.salon "
			+ "order by "
			+ "c.grado, "
			+ "c.salon, "
			+ "a.nombre",nativeQuery = true)
	List<Map<String,Object>> getAsignaturasCol(int col);
	
	@Query(value="select "
			+ "a.id id_asignatura, "
			+ "a.nombre asignatura, "
			+ "p.nombre profesor,"
			+ "c.grado || ' ' || c.salon curso, "
			+ "LISTAGG(e.nombre)  estudiantes "
			+ "from "
			+ "asignatura a "
			+ "join curso c on a.curso = c.id "
			+ "join profesor p on p.id = a.profesor "
			+ "left join asignatura_estudiante ae on ae.asignatura_id = a.id "
			+ "left join estudiante e on e.id = ae.estudiante_id "
			+ "where "
			+ "a.profesor =  (?1) "
			+ "group by "
			+ "a.nombre, "
			+ "p.nombre, "
			+ "c.grado, "
			+ "c.salon "
			+ "order by "
			+ "c.grado, "
			+ "c.salon, "
			+ "a.nombre",nativeQuery = true)
	List<Map<String,Object>> getCursos(int prof);
	
	
	
}
