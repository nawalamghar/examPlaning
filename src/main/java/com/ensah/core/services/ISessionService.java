package com.ensah.core.services;

import java.util.List;

import com.ensah.core.bo.Session;

public interface ISessionService {
	public List<Session> getAllSessions();
	public Session getSessionById(Long ids);
}
