package com.ensah.core.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensah.core.bo.Element;
import com.ensah.core.dao.IElementRepository;
import com.ensah.core.services.IElementService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class elementServiceImpl implements IElementService {

	@Autowired
	private IElementRepository elementDao;
	
	@Override
	public List<Element> getAllElements() {
		
		return elementDao.findAll();
	}

	@Override
	public void addElement(Element pElement) {
		elementDao.save(pElement);
		
	}

	@Override
	public void updateElement(Element pElement) {
		elementDao.save(pElement);
	}

	@Override
	public void deleteElement(Long id) {
		elementDao.deleteById(id);;
	}

	@Override
	public Element getElementById(Long id) {
		
		return elementDao.findById(id).get();
	}

}
