package com.ensah.core.web.models;

import com.ensah.core.bo.Dept;
import com.ensah.core.bo.Element;
import com.ensah.core.bo.Filiere;
import com.ensah.core.bo.Groupe;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public class PersonelModel {

	public static final int TYPE_ADMIN = 1;
	public static final int TYPE_ENS = 2;

	@NotBlank(message = "This field is required")
	private String cin;
	
	private Long idPersonnel;

	@NotBlank(message = "This field is required")
	private String nom;

	@NotBlank(message = "This field is required")
	private String prenom;
	
	
	
	@NotEmpty
	private String email;

	private String telephone;

	
	private Dept dept;
	
	
	private Filiere filiere;
	
	

	private Groupe groupe;
	

	private int typePerson;
	
	
	public PersonelModel() {
		
	}

	public PersonelModel(int typePerson) {
		this.typePerson = typePerson;
	}




	

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
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

	
	public int getTypePerson() {
		return typePerson;
	}

	public void setTypePerson(int typePerson) {
		this.typePerson = typePerson;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	

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

	public static int getTypeAdmin() {
		return TYPE_ADMIN;
	}

	public static int getTypeEns() {
		return TYPE_ENS;
	}

	public Long getIdPersonnel() {
		return idPersonnel;
	}

	public void setIdPersonnel(Long idPersonnel) {
		this.idPersonnel = idPersonnel;
	}

	@Override
	public String toString() {
		return "PersonelModel [cin=" + cin + ", idPersonel=" + idPersonnel + ", nom=" + nom + ", prenom=" + prenom
				+ ", email=" + email + ", telephone=" + telephone + ", dept=" + dept + ", filiere=" + filiere
				+ ", groupe=" + groupe + ", typePerson=" + typePerson + "]";
	}

	

	


}
