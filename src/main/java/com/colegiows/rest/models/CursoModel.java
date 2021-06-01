package com.colegiows.rest.models;


import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "curso")
public class CursoModel {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private int grado;
    private String salon;
    
    @ManyToOne
    @JoinColumn(name = "colegio")
	ColegioModel colegio;
   
    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    List<AsignaturaModel> asignaturas;

	public CursoModel() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getGrado() {
		return grado;
	}

	public void setGrado(int grado) {
		this.grado = grado;
	}

	public String getSalon() {
		return salon;
	}

	public void setSalon(String salon) {
		this.salon = salon;
	}

	public ColegioModel getColegio() {
		return colegio;
	}

	public void setColegio(ColegioModel colegio) {
		this.colegio = colegio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((asignaturas == null) ? 0 : asignaturas.hashCode());
		result = prime * result + ((colegio == null) ? 0 : colegio.hashCode());
		result = prime * result + grado;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((salon == null) ? 0 : salon.hashCode());
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
		CursoModel other = (CursoModel) obj;
		if (asignaturas == null) {
			if (other.asignaturas != null)
				return false;
		} else if (!asignaturas.equals(other.asignaturas))
			return false;
		if (colegio == null) {
			if (other.colegio != null)
				return false;
		} else if (!colegio.equals(other.colegio))
			return false;
		if (grado != other.grado)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (salon == null) {
			if (other.salon != null)
				return false;
		} else if (!salon.equals(other.salon))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CursoModel [id=" + id + ", grado=" + grado + ", salon=" + salon + ", colegio=" + colegio
				+ ", asignaturas=" + asignaturas + "]";
	}
    
    
	

    
}
