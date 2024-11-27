package com.ensah.core.web.models;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.web.multipart.MultipartFile;

import com.ensah.core.bo.Element;
import com.ensah.core.bo.Salle;
import com.ensah.core.bo.Semestre;
import com.ensah.core.bo.Session;
import com.ensah.core.bo.Surveillance;
import com.ensah.core.bo.TypeExam;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;

public class ExamenModel {
	
	
	private Long IdExam;
	
	private Element element;
	//private int nbrS;
	private Set<Surveillance> surveillances;
	
	private Set<Salle> salles;
	
	private Map<Long, Integer> nbrS;
	
	private Semestre semestre;
	
	private Session session;
	
	private TypeExam type;
	
	@Temporal(TemporalType.DATE)
	private Date date;
	private LocalTime heureDebut;
	
	private LocalTime durePrevu;
	
	private LocalTime dureReelle;
	
	
	private String anneUni;
	
	private MultipartFile eprouveFile;
	private String eprouve;
	
	private MultipartFile pvFile;
	private String pv;
	
	private String rapportText;
	
	private int choix;

	public Long getIdExam() {
		return IdExam;
	}

	public void setIdExam(Long idExam) {
		IdExam = idExam;
	}

	public Element getElement() {
		return element;
	}

	public void setElement(Element element) {
		this.element = element;
	}

	public Set<Surveillance> getSurveillances() {
		return surveillances;
	}

	public void setSurveillances(Set<Surveillance> surveillances) {
		this.surveillances = surveillances;
	}

	public Set<Salle> getSalles() {
		return salles;
	}

	public void setSalles(Set<Salle> salles) {
		this.salles = salles;
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

	public int getChoix() {
		return choix;
	}

	public void setChoix(int choix) {
		this.choix = choix;
	}

	

	public MultipartFile getEprouveFile() {
		return eprouveFile;
	}

	public void setEprouveFile(MultipartFile eprouveFile) {
		this.eprouveFile = eprouveFile;
	}

	public MultipartFile getPvFile() {
		return pvFile;
	}

	public void setPvFile(MultipartFile pvFile) {
		this.pvFile = pvFile;
	}

	public Map<Long, Integer> getNbrS() {
		return nbrS;
	}

	public void setNbrS(Map<Long, Integer> nbrS) {
		this.nbrS = nbrS;
	}


}
