package com.ensah.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ensah.core.bo.TypeExam;

public interface ITypeExamReository  extends JpaRepository<TypeExam,Long> {

	
}
