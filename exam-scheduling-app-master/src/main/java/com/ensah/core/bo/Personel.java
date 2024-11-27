package com.ensah.core.bo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Personel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPersonnel;
	
	@Column(unique = true)
	private String cin;

	
	private String email;

	private String telephone;

	@NotBlank(message = "This field is required")
	private String prenom;

	@NotBlank(message = "This field is required")
	private String nom;

	
	@Override
	public String toString() {
		return "Person [idPersonne=" + idPersonnel + ", firstName="
				+ prenom + ", lastName=" + nom + "]";
	}


	public Long getIdPersonnel() {
		return idPersonnel;
	}

	public void setIdPersonnel(Long idPersonnel) {
		this.idPersonnel = idPersonnel;
	}

	
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getCin() {
		return cin;
	}


	public void setCin(String cin) {
		this.cin = cin;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	

}
