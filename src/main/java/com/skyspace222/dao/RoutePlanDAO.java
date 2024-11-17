package com.skyspace222.dao;

import java.util.List;

import com.skyspace222.dao.GenericDAO;
import com.skyspace222.domain.RoutePlan;





public interface RoutePlanDAO extends GenericDAO<RoutePlan, Integer> {
  
	List<RoutePlan> findAll();
	






}


