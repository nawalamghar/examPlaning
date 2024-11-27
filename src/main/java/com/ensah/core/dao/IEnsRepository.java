package com.ensah.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ensah.core.bo.Enseignant;

public interface IEnsRepository extends JpaRepository<Enseignant,Long>{

}
