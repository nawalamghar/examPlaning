package com.ensah.core.bo;

import java.util.Set;

import jakarta.persistence.*;

@Entity
public class Niveau {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long IdNiveau;
	
	private String titreN;
	
	@OneToMany(mappedBy="niveau")
	private Set<Element> elements;
	
	

	public Long getIdNiveau() {
		return IdNiveau;
	}

	public void setIdNiveau(Long idNiveau) {
		IdNiveau = idNiveau;
	}

	public String getTitreN() {
		return titreN;
	}

	public void setTitreN(String titreN) {
		this.titreN = titreN;
	}

	public Set<Element> getElements() {
		return elements;
	}

	public void setElements(Set<Element> elements) {
		this.elements = elements;
	}

	@Override
	public String toString() {
		return "Niveau [IdNiveau=" + IdNiveau + ", titreN=" + titreN + "]";
	}
	

}
