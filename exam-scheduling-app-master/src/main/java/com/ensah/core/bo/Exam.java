package com.ensah.core.bo;

import java.time.LocalTime;
import java.util.Date;
import java.util.Set;

import jakarta.persistence.*;

@Entity
public class Exam {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long IdExam;
	
	
	
	@ManyToOne
	@JoinColumn(name="id_element")
	private Element element;

	@OneToMany(mappedBy="exam",cascade=CascadeType.ALL,orphanRemoval = true)
	private Set<Surveillance> surveillances;
	
	@ManyToOne
	@JoinColumn(name="id_semestre")
	private Semestre semestre;
	
	@ManyToOne
	@JoinColumn(name="id_session")
	private Session session;
	
	@ManyToOne
	@JoinColumn(name="id_typeExam")
	private TypeExam type;
	
	
	@Temporal(TemporalType.DATE)
	private Date date;
	
	
	private LocalTime heureDebut;
	
	private LocalTime durePrevu;
	
	private LocalTime dureReelle;
	
	
	private String anneUni;
	
	private String eprouve;
	
	private String pv;
	
	private String rapportText;

	public Long getIdExam() {
		return IdExam;
	}

	public void setIdExam(Long idExam) {
		IdExam = idExam;
	}
	
	public Set<Surveillance> getSurveillances() {
		return surveillances;
	}

	public void setSurveillances(Set<Surveillance> surveillances) {
		this.surveillances = surveillances;
	}

	public Semestre getSemestre() {
		return semestre;
	}

	public void setSemestre(Semestre semestre) {
		this.semestre = semestre;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public TypeExam getType() {
		return type;
	}

	public void setType(TypeExam type) {
		this.type = type;
	}

	

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public LocalTime getHeureDebut() {
		return heureDebut;
	}

	public void setHeureDebut(LocalTime heureDebut) {
		this.heureDebut = heureDebut;
	}

	public LocalTime getDurePrevu() {
		return durePrevu;
	}

	public void setDurePrevu(LocalTime durePrevu) {
		this.durePrevu = durePrevu;
	}

	public LocalTime getDureReelle() {
		return dureReelle;
	}

	public Element getElement() {
		return element;
	}

	public void setElement(Element element) {
		this.element = element;
	}

	public void setDureReelle(LocalTime dureReelle) {
		this.dureReelle = dureReelle;
	}

	

	public String getAnneUni() {
		return anneUni;
	}

	public void setAnneUni(String anneUni) {
		this.anneUni = anneUni;
	}

	public String getEprouve() {
		return eprouve;
	}

	public void setEprouve(String eprouve) {
		this.eprouve = eprouve;
	}

	public String getPv() {
		return pv;
	}

	public void setPv(String pv) {
		this.pv = pv;
	}

	public String getRapportText() {
		return rapportText;
	}

	public void setRapportText(String rapportText) {
		this.rapportText = rapportText;
	}

	
	
	@Override
	public String toString() {
		return "Exam [IdExam=" + IdExam + ", semestre=" + semestre + ", session=" + session + ", type=" + type
				+ ", date=" + date + ", heureDebut=" + heureDebut + ", durePrevu=" + durePrevu + ", dureReelle="
				+ dureReelle + ", anneUni=" + anneUni + ", eprouve=" + eprouve
				+ ", pv=" + pv + ", rapportText=" + rapportText + "]";
	}

	
	
}
