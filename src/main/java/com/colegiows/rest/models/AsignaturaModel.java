package com.colegiows.rest.models;


import java.util.List;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "asignatura")
@Inheritance(strategy = InheritanceType.JOINED)
public class AsignaturaModel {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;
	
	private String nombre;
	
	
	@ManyToOne
	@JoinColumn(name = "profesor")
	ProfesorModel profesor;
	
	@JsonIgnore
	@ManyToMany
	List<EstudianteModel> estudiante;

	@ManyToOne
    @JoinColumn(name = "curso")
	CursoModel curso;
	
	public AsignaturaModel() {
		super();
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public CursoModel getCurso() {
		return curso;
	}

	public void setCurso(CursoModel curso) {
		this.curso = curso;
	}
	
	public ProfesorModel getProfesor() {
		return profesor;
	}

	public void setProfesor(ProfesorModel profesor) {
		this.profesor = profesor;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((curso == null) ? 0 : curso.hashCode());
		result = prime * result + ((estudiante == null) ? 0 : estudiante.hashCode());
		result = prime * result + id;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((profesor == null) ? 0 : profesor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AsignaturaModel other = (AsignaturaModel) obj;
		if (curso == null) {
			if (other.curso != null)
				return false;
		} else if (!curso.equals(other.curso))
			return false;
		if (estudiante == null) {
			if (other.estudiante != null)
				return false;
		} else if (!estudiante.equals(other.estudiante))
			return false;
		if (id != other.id)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (profesor == null) {
			if (other.profesor != null)
				return false;
		} else if (!profesor.equals(other.profesor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AsignaturaModel [id=" + id + ", nombre=" + nombre + ", profesor=" + profesor + ", estudiante="
				+ estudiante + ", curso=" + curso + "]";
	}
	
	
	
}