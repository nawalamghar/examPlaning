package com.ensah.core.services.impl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensah.core.bo.Administrateur;
import com.ensah.core.bo.DateUtils;
import com.ensah.core.dao.IAdminRepository;
import com.ensah.core.services.IAdminService;
import com.ensah.core.services.IExamenService;
import com.ensah.core.services.ISurvService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class IAdminServiceImpl implements IAdminService {

	@Autowired
	private IAdminRepository adminDao;
	
	@Override
	public List<Administrateur> getAllAdmins() {
		return adminDao.findAll();
	}

	@Override
	public List<Administrateur> getAllAdminsNotInDateExam(Date d) {
		//getExamsByDate
		//
		return null;
	}
	@Autowired 
	private IExamenService examenService;
	@Autowired
	private ISurvService survService;
	@Override
	
	public List<Administrateur> findAdminsNotSurv(List<Long> aIds) {
		
		LocalDate examd=LocalDate.of(2024, 05, 07);
		System.out.println(examenService.getExamByDate(DateUtils.asDate(examd)));
		List<Long> listId = new ArrayList<>();
		examenService.getExamByDate(DateUtils.asDate(examd)).forEach( e -> listId.add(e.getIdExam()));
		System.out.println(listId);
		//System.out.println(survService.findIdAdminsByExamIds(listId));
		return null;
	}

}
