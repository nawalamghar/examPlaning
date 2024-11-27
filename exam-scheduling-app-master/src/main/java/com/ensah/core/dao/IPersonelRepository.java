package com.ensah.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ensah.core.bo.Personel;
import com.ensah.core.bo.Personne;

public interface IPersonelRepository extends JpaRepository<Personel, Long> {


	Personel getPersonelByCin(String cin);

}
