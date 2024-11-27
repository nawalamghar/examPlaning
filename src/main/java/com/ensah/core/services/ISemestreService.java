package com.ensah.core.services;

import java.util.List;

import com.ensah.core.bo.Semestre;

public interface ISemestreService {
	public List<Semestre> getAllSemestre();
	public Semestre getSemestreById(Long ids); 
}
