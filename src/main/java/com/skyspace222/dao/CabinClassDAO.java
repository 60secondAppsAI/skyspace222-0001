package com.skyspace222.dao;

import java.util.List;

import com.skyspace222.dao.GenericDAO;
import com.skyspace222.domain.CabinClass;





public interface CabinClassDAO extends GenericDAO<CabinClass, Integer> {
  
	List<CabinClass> findAll();
	






}


