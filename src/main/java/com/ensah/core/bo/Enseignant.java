package com.ensah.core.bo;

import java.util.Set;

import jakarta.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name = "idEnseignant")
public class Enseignant extends Personel {
	
	@ManyToOne
	@JoinColumn(name="id_dept")
	private Dept dept;
	
	@ManyToOne
	@JoinColumn(name="id_filiere")
	private Filiere filiere;
	
	@ManyToOne
	@JoinColumn(name="id_groupe")
	private Groupe groupe;
	
	
	@OneToMany(mappedBy="ens")
	private Set<Element> elements;
	
	@OneToMany(mappedBy="coord")
	private Set<Element> elementss;
	
//	@ManyToMany(cascade=CascadeType.ALL)
//	@JoinTable(name="surveillance_enseignant",
//	joinColumns=@JoinColumn(name="id_enseignant"),
//	inverseJoinColumns=@JoinColumn(name="id_surveillance"))
//	private Set<Surveillance> surveillancesEns;
	
	
	@ManyToMany(mappedBy = "enseignants")
    private Set<Surveillance> surveillancesEns ;
	
	@OneToMany(mappedBy="coordExam",cascade=CascadeType.ALL)
	private Set<Surveillance> surveillancesCoord;
	
	
	

	public Dept getDept() {
		return dept;
	}


	public void setDept(Dept dept) {
		this.dept = dept;
	}


	public Filiere getFiliere() {
		return filiere;
	}


	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}


	public Groupe getGroupe() {
		return groupe;
	}


	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}


	public Set<Surveillance> getSurveillancesEns() {
		return surveillancesEns;
	}


	public void setSurveillancesEns(Set<Surveillance> surveillancesEns) {
		this.surveillancesEns = surveillancesEns;
	}


	public Set<Surveillance> getSurveillancesCoord() {
		return surveillancesCoord;
	}


	public void setSurveillancesCoord(Set<Surveillance> surveillancesCoord) {
		this.surveillancesCoord = surveillancesCoord;
	}


	public Set<Element> getElements() {
		return elements;
	}


	public void setElements(Set<Element> elements) {
		this.elements = elements;
	}


	


	
	
	
    
	
	

}
