package com.colegiows.rest.models;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "estudiante")
public class EstudianteModel {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    public int id;
	
    private String nombre;
    
    @JsonIgnore
    @ManyToMany(mappedBy = "estudiante", cascade = CascadeType.ALL)
    List<AsignaturaModel> asignatura;
    
    public EstudianteModel() {
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
	

	public List<AsignaturaModel> getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(List<AsignaturaModel> asignatura) {
		this.asignatura = asignatura;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((asignatura == null) ? 0 : asignatura.hashCode());
		result = prime * result + id;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		EstudianteModel other = (EstudianteModel) obj;
		if (asignatura == null) {
			if (other.asignatura != null)
				return false;
		} else if (!asignatura.equals(other.asignatura))
			return false;
		if (id != other.id)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EstudianteModel [id=" + id + ", nombre=" + nombre + ", asignatura=" + asignatura + "]";
	}

	
	
	

}