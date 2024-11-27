package com.ensah.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ensah.core.bo.Dept;

public interface IDeptRepository extends JpaRepository<Dept,Long>{
	
}
