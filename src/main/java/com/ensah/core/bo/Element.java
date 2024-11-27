package com.ensah.core.bo;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Element {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idElement;
	
	@NotBlank(message = "This field is required")
	private String titre;
	
	
	
	
	@ManyToOne
    @JoinColumn(name = "id_coordinateur")
    private Enseignant coord;
	
	@ManyToOne
    @JoinColumn(name = "id_type")
	private Type type;
	
	@ManyToOne
    @JoinColumn(name = "id_niveau")
	private Niveau niveau;
	
	@ManyToOne
	@JoinColumn(name="id_enseignant")
	private Enseignant ens;
	
	@OneToMany(mappedBy="element",cascade=CascadeType.ALL)
	private Set<Exam> exams;
	
	public Set<Exam> getExams() {
		return exams;
	}

	public void setExams(Set<Exam> exams) {
		this.exams = exams;
	}

	
	
	
	

	public Long getId() {
		return idElement;
	}

	public void setId(Long id) {
		this.idElement = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	

	public Long getIdElement() {
		return idElement;
	}

	public void setIdElement(Long idElement) {
		this.idElement = idElement;
	}

	

	public Enseignant getCoord() {
		return coord;
	}

	public void setCoord(Enseignant coord) {
		this.coord = coord;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Niveau getNiveau() {
		return niveau;
	}

	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}

	public Enseignant getEns() {
		return ens;
	}

	public void setEns(Enseignant ens) {
		this.ens = ens;
	}

	@Override
	public String toString() {
		return "Element [idElement=" + idElement + ", titre=" + titre +  ", coord="
				+ coord + ", type=" + type + ", niveau=" + niveau + "]";
	}

	

	
	

}
