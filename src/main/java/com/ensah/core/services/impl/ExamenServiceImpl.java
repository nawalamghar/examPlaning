package com.ensah.core.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensah.core.bo.Element;
import com.ensah.core.bo.Exam;
import com.ensah.core.dao.IExamenRepository;
import com.ensah.core.services.IExamenService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ExamenServiceImpl implements IExamenService {

	@Autowired
	private IExamenRepository examenDao;
	@Override
	public List<Exam> getAllExamens() {
		return  examenDao.findAll();
	}

	@Override
	public void addExamen(Exam pExamen) {
		 examenDao.save(pExamen);
	}

	@Override
	public void updateExamen(Exam pExamen) {
		examenDao.save(pExamen);
	}

	@Override
	public void deleteExamen(Long id) {
		examenDao.deleteById(id);
	}

	@Override
	public Exam getExamenById(Long id) {
		return examenDao.findById(id).get();
	}

	@Override
	public List<Exam> getExamByDate(Date date) {
		return examenDao.getExamsByDate(date);
	}

}
