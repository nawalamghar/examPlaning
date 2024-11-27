package com.ensah.core.services;

import java.sql.Date;
import java.util.List;

import org.springframework.data.repository.query.Param;

import com.ensah.core.bo.Administrateur;

public interface IAdminService {
	public List<Administrateur> getAllAdmins();
	
	public List<Administrateur> getAllAdminsNotInDateExam(Date d);
	
	public List<Administrateur> findAdminsNotSurv(List<Long> aIds);
}
