package com.skyspace222.dao;

import java.util.List;

import com.skyspace222.dao.GenericDAO;
import com.skyspace222.domain.FrequentFlyer;





public interface FrequentFlyerDAO extends GenericDAO<FrequentFlyer, Integer> {
  
	List<FrequentFlyer> findAll();
	






}


