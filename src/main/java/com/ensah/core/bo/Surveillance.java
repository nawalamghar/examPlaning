package com.ensah.core.bo;

import jakarta.persistence.*;
import java.util.*;
@Entity
public class Surveillance {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idSurveillance;
	
	@ManyToOne
	@JoinColumn(name="id_admin")
	private Administrateur admin;
	
//	@ManyTvoMany(mappedBy="surveillancesEns")
//	private Set<Enseignant> enseignants;
	
	 @ManyToMany(cascade = CascadeType.ALL)
	    @JoinTable(
	        name = "surveillance_enseignant",
	        joinColumns = @JoinColumn(name = "id_surveillance"),
	        inverseJoinColumns = @JoinColumn(name = "id_enseignant")
	    )
	  private Set<Enseignant> enseignants = new HashSet<>();
	 
	@ManyToOne
	@JoinColumn(name="id_coordExam")
	private Enseignant coordExam;
	
	@ManyToOne
	@JoinColumn(name="id_salle")
	private Salle salle;
	
	@ManyToOne
	@JoinColumn(name="id_exam")
	private Exam exam;

	public Long getIdSurveillance() {
		return idSurveillance;
	}

	public void setIdSurveillance(Long idSurveillance) {
		this.idSurveillance = idSurveillance;
	}

	public Administrateur getAdmin() {
		return admin;
	}

	public void setAdmin(Administrateur admin) {
		this.admin = admin;
	}

	public Set<Enseignant> getEnseignants() {
		return enseignants;
	}

	public void setEnseignants(Set<Enseignant> enseignants) {
		this.enseignants = enseignants;
	}

	public Enseignant getCoordExam() {
		return coordExam;
	}
	public void setCoordExam(Enseignant coordExam) {
		this.coordExam = coordExam;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}
	
	
}
