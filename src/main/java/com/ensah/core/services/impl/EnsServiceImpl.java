package com.ensah.core.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensah.core.bo.Enseignant;
import com.ensah.core.dao.IEnsRepository;
import com.ensah.core.services.IEnsService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EnsServiceImpl implements IEnsService{
	@Autowired
	private IEnsRepository ensDao;
	@Override
	public List<Enseignant> getAllEnsiegnants() {
		return ensDao.findAll();
	}

}
