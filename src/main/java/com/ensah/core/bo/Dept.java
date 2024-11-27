package com.ensah.core.bo;

import java.util.Set;
import jakarta.persistence.*;

@Entity
public class Dept {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idDept;
	
	private String titreD;
	
	@OneToMany(mappedBy="dept",cascade=CascadeType.ALL)
	private Set<Enseignant> enseignants;

	
	
	public String getTitreD() {
		return titreD;
	}

	public void setTitreD(String titreD) {
		this.titreD = titreD;
	}

	public Long getIdDept() {
		return idDept;
	}

	public void setIdDept(Long idDept) {
		this.idDept = idDept;
	}

	public Set<Enseignant> getEnseignants() {
		return enseignants;
	}

	public void setEnseignants(Set<Enseignant> enseignants) {
		this.enseignants = enseignants;
	}
	
	@Override
	public String toString() {
		return "Dept [enseignants=" + enseignants + "]";
	}
	
}
