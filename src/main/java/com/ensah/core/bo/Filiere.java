package com.ensah.core.bo;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Filiere {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idFiliere;
	
	private String titreF;
	
	@OneToMany(mappedBy="filiere",cascade=CascadeType.ALL)
	private Set<Enseignant> enseignants;

	
	public String getTitreF() {
		return titreF;
	}

	public void setTitreF(String titreF) {
		this.titreF = titreF;
	}

	public Long getIdFiliere() {
		return idFiliere;
	}

	public void setIdFiliere(Long idFiliere) {
		this.idFiliere = idFiliere;
	}

	public Set<Enseignant> getEnseignants() {
		return enseignants;
	}

	public void setEnseignants(Set<Enseignant> enseignants) {
		this.enseignants = enseignants;
	}

	@Override
	public String toString() {
		return "Filiere [enseignants=" + enseignants + "]";
	}
	
}
