package com.ensah.core.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensah.core.bo.Niveau;
import com.ensah.core.dao.INiveauRepository;
import com.ensah.core.services.INiveauService;

import jakarta.transaction.Transactional;

@Service 
@Transactional
public class NiveauServiceImpl implements INiveauService {

	@Autowired
	private INiveauRepository nivDao;
	@Override
	public List<Niveau> getAllNiveaux() {
		return nivDao.findAll();
	}
	

}
