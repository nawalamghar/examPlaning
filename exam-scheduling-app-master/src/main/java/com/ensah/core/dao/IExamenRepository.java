package com.ensah.core.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ensah.core.bo.Exam;

public interface IExamenRepository extends JpaRepository<Exam,Long> {
	
	@Query("select e from Exam e where e.date = :date")
	public List<Exam> getExamsByDate(@Param("date") Date date);

}
