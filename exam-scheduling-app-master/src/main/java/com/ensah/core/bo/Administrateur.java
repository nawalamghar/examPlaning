package com.ensah.core.bo;

import jakarta.persistence.*;

import java.util.*;

@Entity
@PrimaryKeyJoinColumn(name = "idAdmin")
public class Administrateur extends Personel{
	
	
	//administrateur qui assure l'abscence 
	@OneToMany(mappedBy="admin",cascade=CascadeType.ALL)
	private Set<Surveillance> surveillances;

	public Set<Surveillance> getSurveillances() {
		return surveillances;
	}

	public void setSurveillances(Set<Surveillance> surveillances) {
		this.surveillances = surveillances;
	}
	

}
