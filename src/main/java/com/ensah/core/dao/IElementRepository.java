package com.ensah.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ensah.core.bo.Element;

public interface IElementRepository extends JpaRepository<Element,Long> {

}
