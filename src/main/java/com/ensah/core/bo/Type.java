package com.ensah.core.bo;

import java.util.Set;

import jakarta.persistence.*;

@Entity
public class Type {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idType;
	
	private String titreT;

	@OneToMany(mappedBy="type")
	private Set<Element> elements;
	
	public Long getIdType() {
		return idType;
	}

	public void setIdType(Long idType) {
		this.idType = idType;
	}

	public String getTitreT() {
		return titreT;
	}

	public void setTitreT(String titreT) {
		this.titreT = titreT;
	}

	public Set<Element> getElements() {
		return elements;
	}

	public void setElements(Set<Element> elements) {
		this.elements = elements;
	}

	@Override
	public String toString() {
		return "Type [idType=" + idType + ", titreT=" + titreT + "]";
	}

}
