package com.skyspace222.dao;

import java.util.List;

import com.skyspace222.dao.GenericDAO;
import com.skyspace222.domain.Meal;





public interface MealDAO extends GenericDAO<Meal, Integer> {
  
	List<Meal> findAll();
	






}


