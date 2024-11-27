package com.ensah.core.services;

import java.util.List;

import com.ensah.core.bo.Element;
import com.ensah.core.bo.Personel;
import com.ensah.core.utils.ExcelExporter;

public interface IElementService {
	
	public List<Element> getAllElements();
	
	public void addElement(Element pElement);

	public void updateElement(Element pElement);

	public void deleteElement(Long id);

	public Element getElementById(Long id);
	
	//public Personel getPersonneByCin(String cin);
	
	//public ExcelExporter preparePersonneExport(List<Personel> persons);

}
