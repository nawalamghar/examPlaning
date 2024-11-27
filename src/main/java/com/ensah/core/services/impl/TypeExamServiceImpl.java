package com.ensah.core.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensah.core.bo.TypeExam;
import com.ensah.core.dao.ITypeExamReository;
import com.ensah.core.services.ITypeExamService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TypeExamServiceImpl implements ITypeExamService{

	@Autowired
	private ITypeExamReository typeExamDao;
	@Override
	public List<TypeExam> getAllTypeExam() {
		
		return typeExamDao.findAll();
	}
	@Override
	public TypeExam getTypeExamById(Long idT) {
		return typeExamDao.findById(idT).get();
	}
	

}
