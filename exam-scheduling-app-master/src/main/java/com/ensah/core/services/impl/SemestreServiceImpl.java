package com.ensah.core.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensah.core.bo.Semestre;
import com.ensah.core.dao.ISemestreRepository;
import com.ensah.core.services.ISemestreService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class SemestreServiceImpl implements ISemestreService {
	
	@Autowired
	private ISemestreRepository semestreDao;
	
	@Override
	public List<Semestre> getAllSemestre() {
		
		return semestreDao.findAll();
	}

	@Override
	public Semestre getSemestreById(Long ids) {
		return semestreDao.findById(ids).get();
	}

}
