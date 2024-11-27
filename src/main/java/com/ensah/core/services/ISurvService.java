package com.ensah.core.services;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ensah.core.bo.Administrateur;
import com.ensah.core.bo.Enseignant;
import com.ensah.core.bo.Exam;
import com.ensah.core.bo.Salle;
import com.ensah.core.bo.Surveillance;

public interface ISurvService {
	
	 public List<Surveillance> getAllSurveillance();
		
		public void addSurveillance(Surveillance pSurveillance);

		public void updateSurveillance(Surveillance pSurveillance);

		public void deleteSurveillance(Long id);

		public Surveillance getSurveillanceById(Long id);
		
		//List<Long> findIdAdminsByExamIds(List<Long> examIds);
		
		List<Administrateur> getAdminsAssignedToExamsOnDate(Date examDate);
		List<Enseignant> getEnsAssignedToExamsOnDate(Date examDate);
		
		List<Salle> getSallesByExam(List<Exam> exams);
		
		Exam getExamBySalle(Salle s);
		
		
		 Enseignant getCoordExamBySalle(Salle salle);
		    
		 Administrateur getControleurAbscenceBySalle(Salle salle);
		    
		 Surveillance getSurveillanceSalle(Salle salle,Exam exam);


}
