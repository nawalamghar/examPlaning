package com.ensah.core.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensah.core.bo.Type;
import com.ensah.core.dao.ITypeRepository;
import com.ensah.core.services.ITypeService;

import jakarta.transaction.Transactional;

@Service 
@Transactional
public class TypeServiceImlp implements  ITypeService{

		
	@Autowired
	private ITypeRepository typeDao;
	@Override
	public List<Type> getAllType() {
		return typeDao.findAll();
	}
	
}
