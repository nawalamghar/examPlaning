package com.ensah.core.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensah.core.bo.Session;
import com.ensah.core.dao.ISessionRepository;
import com.ensah.core.services.ISessionService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class SessionServiceImpl implements ISessionService{

	
	@Autowired
	private ISessionRepository sessionDao;
	
	@Override
	public List<Session> getAllSessions() {
		
		return sessionDao.findAll();
	}

	@Override
	public Session getSessionById(Long ids) {
		return sessionDao.findById(ids).get();
	}

}
