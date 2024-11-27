package com.ensah.core.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ensah.core.bo.Administrateur;
import com.ensah.core.bo.Enseignant;
import com.ensah.core.bo.Exam;
import com.ensah.core.bo.Salle;
import com.ensah.core.bo.Surveillance;

public interface ISurvReository extends JpaRepository<Surveillance,Long> {
	
    @Query("SELECT s.admin FROM Surveillance s WHERE s.exam IN :exams")
    List<Administrateur> findIdAdminsByExamIds(@Param("exams") List<Exam> exams);
    
    
    @Query("SELECT s.enseignants FROM Surveillance s WHERE s.exam IN :exams ")
    List<Enseignant> findIdEnsByExamIds(@Param("exams") List<Exam> exams);
    
    @Query("SELECT s.salle FROM Surveillance s where s.exam IN :exams")
    List<Salle> findSallesByExamIds(@Param("exams") List<Exam> exams);
    
    @Query("SELECT s.exam from Surveillance s where s.salle = :salle")
    Exam findExamBySalle(@Param("salle") Salle salle);
    
    @Query("select s.coordExam from Surveillance s where s.salle = :salle")
    Enseignant getCoordBySalle(@Param("salle") Salle salle);
    
    @Query("select s.admin from Surveillance s where s.salle = :salle")
    Administrateur getAdminBySalle(@Param("salle") Salle salle);
    
    
    @Query("select s from Surveillance s where s.salle = :salle and s.exam= :exam")
    Surveillance getIdSurvBySalle(@Param("salle") Salle salle,@Param("exam") Exam exam);
}
