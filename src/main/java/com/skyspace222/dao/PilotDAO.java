package com.skyspace222.dao;

import java.util.List;

import com.skyspace222.dao.GenericDAO;
import com.skyspace222.domain.Pilot;





public interface PilotDAO extends GenericDAO<Pilot, Integer> {
  
	List<Pilot> findAll();
	






}


