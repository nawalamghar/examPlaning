package com.ensah.core.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensah.core.bo.Dept;
import com.ensah.core.dao.IDeptRepository;
import com.ensah.core.services.IDeptService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class DeptServiceImpl implements IDeptService {

	
	@Autowired
	private IDeptRepository deptDao;
	@Override
	public List<Dept> getAllDepts() {
		
		return deptDao.findAll();
		
	}

}
