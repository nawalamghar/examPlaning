package com.ensah.core.services;

import java.util.List;

import com.ensah.core.bo.TypeExam;

public interface ITypeExamService {
	
	public List<TypeExam> getAllTypeExam(); 
	public TypeExam getTypeExamById(Long idT);
}
