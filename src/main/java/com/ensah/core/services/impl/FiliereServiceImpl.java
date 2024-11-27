package com.ensah.core.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensah.core.bo.Filiere;
import com.ensah.core.dao.IFiliereRepository;
import com.ensah.core.services.IFiliereService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class FiliereServiceImpl implements IFiliereService {

	
	@Autowired
	private IFiliereRepository filiereDao;
	
	@Override
	public List<Filiere> getAllFiliers() {
		return filiereDao.findAll();
	}

}
