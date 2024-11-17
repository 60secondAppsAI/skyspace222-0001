package com.skyspace222.dao;

import java.util.List;

import com.skyspace222.dao.GenericDAO;
import com.skyspace222.domain.Luggage;





public interface LuggageDAO extends GenericDAO<Luggage, Integer> {
  
	List<Luggage> findAll();
	






}


