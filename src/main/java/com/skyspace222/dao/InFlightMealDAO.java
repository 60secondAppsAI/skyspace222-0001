package com.skyspace222.dao;

import java.util.List;

import com.skyspace222.dao.GenericDAO;
import com.skyspace222.domain.InFlightMeal;





public interface InFlightMealDAO extends GenericDAO<InFlightMeal, Integer> {
  
	List<InFlightMeal> findAll();
	






}


