package com.ensah.core.services;

import java.util.List;

import com.ensah.core.bo.Personel;
import com.ensah.core.bo.Personne;
import com.ensah.core.utils.ExcelExporter;

public interface IPersonelService {
	
	public void addPersonne(Personel pPerson);

	public void updatePersonne(Personel pPerson);

	public List<Personel> getAllPersonnes();

	public void deletePersonne(Long id);

	public Personel getPersonneById(Long id);
	
	public Personel getPersonneByCin(String cin);
	
	public ExcelExporter preparePersonneExport(List<Personel> persons);

}
