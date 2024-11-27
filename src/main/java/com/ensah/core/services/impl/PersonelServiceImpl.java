package com.ensah.core.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ensah.core.bo.Personel;
import com.ensah.core.bo.Personne;
import com.ensah.core.dao.IPersonelRepository;
import com.ensah.core.services.IPersonelService;
import com.ensah.core.utils.ExcelExporter;

@Service
@Transactional
public class PersonelServiceImpl implements IPersonelService {
	
	@Autowired
	private IPersonelRepository personDao;

	public List<Personel> getAllPersonnes() {

		return personDao.findAll();
	}

	public void deletePersonne(Long id) {
		personDao.deleteById(id);

	}

	public Personel getPersonneById(Long id) {
		return personDao.findById(id).get();

	}

	public void addPersonne(Personel pPerson) {
		personDao.save(pPerson);

	}

	public void updatePersonne(Personel pPerson) {
		personDao.save(pPerson);

	}

	public ExcelExporter preparePersonneExport(List<Personel> persons) {
		String[] columnNames = new String[] { "Nom", "Prénom", "CIN", "Email", "Télé" };
		String[][] data = new String[persons.size()][5];

		int i = 0;
		for (Personel u : persons) {
			data[i][0] = u.getNom();
			data[i][1] = u.getPrenom();
			data[i][2] = u.getCin();
			data[i][3] = u.getEmail();
			data[i][4] = u.getTelephone();
			i++;
		}

		return new ExcelExporter(columnNames, data, "persons");

	}

	public Personel getPersonneByCin(String cin) {

		return personDao.getPersonelByCin(cin);

	}

	
}
