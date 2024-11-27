package com.ensah.core.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ensah.core.bo.Administrateur;

public interface IAdminRepository extends JpaRepository<Administrateur,Long>{
	
	@Query("SELECT a FROM Administrateur a WHERE a.idPersonnel NOT IN :aIds")
    List<Administrateur> findAdminsNotSurv(@Param("aIds") List<Long> aIds);
}
