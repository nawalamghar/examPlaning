package com.ensah.core.bo;

import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "salle")
public class Salle {
    
    public Set<Surveillance> getSurveillances() {
		return surveillances;
	}

	public void setSurveillances(Set<Surveillance> surveillances) {
		this.surveillances = surveillances;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_salle")
    private Long idSalle;
    
    @Column(name = "nom")
    private String nom;
    
    @Column(name = "capacity")
    private int capacity;
    
    
    @OneToMany(mappedBy="salle",cascade=CascadeType.ALL)
    private Set<Surveillance> surveillances;
    
    
    public Salle() {}

    public Salle(String nom, int capacity) {
        this.nom = nom;
        this.capacity = capacity;
       
        
    }

    public Long getId() {
		return idSalle;
	}

	@Override
	public String toString() {
		return "Salle [idSalle=" + idSalle + ", nom=" + nom + ", capacity=" + capacity 
				+ "";
	}

	public void setId(Long id) {
		this.idSalle = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	

	
	public Long getIdSalle() {
		return idSalle;
	}

	public void setIdSalle(Long idSalle) {
		this.idSalle = idSalle;
	}

	
	

   
}


