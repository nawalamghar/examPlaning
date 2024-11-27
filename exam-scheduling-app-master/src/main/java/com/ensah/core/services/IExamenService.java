package com.ensah.core.services;

import java.util.Date;
import java.util.List;

import com.ensah.core.bo.Exam;

public interface IExamenService {
	
    public List<Exam> getAllExamens();
	
	public void addExamen(Exam pExamen);

	public void updateExamen(Exam pExamen);

	public void deleteExamen(Long id);

	public Exam getExamenById(Long id);
	public List<Exam> getExamByDate(Date date);

}
