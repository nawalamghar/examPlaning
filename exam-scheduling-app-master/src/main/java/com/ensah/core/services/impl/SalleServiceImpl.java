package com.ensah.core.services.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensah.core.bo.Salle;
import com.ensah.core.dao.ISalleRepository;
import com.ensah.core.services.ISalleService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class SalleServiceImpl implements ISalleService {
	@Autowired
	private ISalleRepository salleDao;
	
	
	@Override
	public List<Salle> getAllSalles() {
		
		return salleDao.findAll();
	}
}
