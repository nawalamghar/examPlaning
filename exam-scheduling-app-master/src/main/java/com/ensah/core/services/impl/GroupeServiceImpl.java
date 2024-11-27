package com.ensah.core.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensah.core.bo.Groupe;
import com.ensah.core.dao.IGroupeRepository;
import com.ensah.core.services.IGroupeService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class GroupeServiceImpl implements IGroupeService {
	
	@Autowired
	private IGroupeRepository groupeDao;
	
	@Override
	public List<Groupe> getAllGroupes() {
		return groupeDao.findAll();
	}

}
