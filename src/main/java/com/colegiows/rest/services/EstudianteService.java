package com.colegiows.rest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.colegiows.rest.models.EstudianteModel;
import com.colegiows.rest.repositories.AsignaturaRepository;
import com.colegiows.rest.repositories.EstudianteRepository;

@Service
public class EstudianteService {
	
	@Autowired
	EstudianteRepository estudianteRepository;
	
	@Autowired
	AsignaturaRepository asignaturaRepository;
	
	@PersistenceContext
    private EntityManager entityManager;
	
	public ArrayList<EstudianteModel> getEstudiantes(){
		return (ArrayList<EstudianteModel>) estudianteRepository.findAll();
	}
	
	public List<Map<String,Object>> getEstCol(int col) {
		List<Map<String,Object>> list = estudianteRepository.getEstudiantes(col);
		return list;
	}
	
	public EstudianteModel addEstudiante(EstudianteModel estudiante){
		return estudianteRepository.save(estudiante);
	}
	
	@Transactional
    public void addMatriculaNuevoEst(EstudianteModel estudiante, int asig) {
		EstudianteModel est = estudianteRepository.save(estudiante);
		entityManager.createNativeQuery("insert into asignatura_estudiante values(?,?)")
		.setParameter(1, asig)
		.setParameter(2, est.getId())
		.executeUpdate();
    }
	
	@Transactional
	public void addMatriculaAntiguoEst(int asig,int est) {
		entityManager.createNativeQuery("insert into asignatura_estudiante values(?1,?2)")
		.setParameter(1, asig)
		.setParameter(2, est)
		.executeUpdate();
    }
	
}
