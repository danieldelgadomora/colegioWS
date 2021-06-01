package com.colegiows.rest.models;


import javax.persistence.*;
import java.util.*;



@Entity
@Table(name = "colegio")
public class ColegioModel {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
	
    private String nombre;
    
    @OneToMany(mappedBy = "colegio",cascade = CascadeType.ALL)
    List<CursoModel> cursos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public ColegioModel() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cursos == null) ? 0 : cursos.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		ColegioModel other = (ColegioModel) obj;
		if (cursos == null) {
			if (other.cursos != null)
				return false;
		} else if (!cursos.equals(other.cursos))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
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
		return "ColegioModel [id=" + id + ", nombre=" + nombre + ", cursos=" + cursos + "]";
	}

    
}