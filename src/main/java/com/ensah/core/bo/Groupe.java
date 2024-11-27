package com.ensah.core.bo;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Groupe {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idGroupe;
	
	private String nom;
	
	@OneToMany(mappedBy="groupe",cascade=CascadeType.ALL)
	private Set<Enseignant> Enseignants;
	
	public Long getIdGroupe() {
		return idGroupe;
	}
	public void setIdGroupe(Long idGroupe) {
		this.idGroupe = idGroupe;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	@Override
	public String toString() {
		return "Groupe [idGroupe=" + idGroupe + ", nom=" + nom + "]";
	}
	
	
	

}
