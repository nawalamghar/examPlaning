package com.ensah.core.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.stereotype.Service;

import com.ensah.core.bo.Administrateur;
import com.ensah.core.bo.Enseignant;
import com.ensah.core.bo.Exam;
import com.ensah.core.bo.Salle;
import com.ensah.core.bo.Surveillance;
import com.ensah.core.dao.ISurvReository;
import com.ensah.core.services.IExamenService;
import com.ensah.core.services.ISurvService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ISurvServiceImpl  implements ISurvService{

	@Autowired
	private ISurvReository survDao;
	
	@Autowired
	private IExamenService examService;
	@Override
	public List<Surveillance> getAllSurveillance() {
		return survDao.findAll();
	}

	@Override
	public void addSurveillance(Surveillance pSurveillance) {
		survDao.save(pSurveillance);
	}

	@Override
	public void updateSurveillance(Surveillance pSurveillance) {
		survDao.save(pSurveillance);
	}

	@Override
	public void deleteSurveillance(Long id) {
		survDao.deleteById(id);
	}

	@Override
	public Surveillance getSurveillanceById(Long id) {
		
		return survDao.findById(id).get();
	}

//	@Override
//	public List<Administrateur> findIdAdminsByExamIds(List<Long> examIds) {
//		return survDao.findIdAdminsByExamIds(examIds);
//	}

	@Override
	public List<Administrateur> getAdminsAssignedToExamsOnDate(Date examDate) {
		
		List<Exam> examsDate = examService.getExamByDate(examDate);
		List<Administrateur> listADminAffecte = survDao.findIdAdminsByExamIds(examsDate);
		return listADminAffecte;
	}

	@Override
	public List<Enseignant> getEnsAssignedToExamsOnDate(Date examDate) {
		
		List<Exam> examsDate = examService.getExamByDate(examDate);
		List<Enseignant> listEnsAffecte = survDao.findIdEnsByExamIds(examsDate);
		return listEnsAffecte;
		
	}

	@Override
	public List<Salle> getSallesByExam(List<Exam> exams) {
		return survDao.findSallesByExamIds(exams);
	}

	@Override
	public Exam getExamBySalle(Salle s) {
		return survDao.findExamBySalle(s);
	}

	@Override
	public Enseignant getCoordExamBySalle(Salle salle) {
		
		return survDao.getCoordBySalle(salle);
	}

	@Override
	public Administrateur getControleurAbscenceBySalle(Salle salle) {
		return survDao.getAdminBySalle(salle);
	}

	@Override
	public Surveillance getSurveillanceSalle(Salle salle,Exam exam) {
		return survDao.getIdSurvBySalle(salle,exam);
	}

	
}
