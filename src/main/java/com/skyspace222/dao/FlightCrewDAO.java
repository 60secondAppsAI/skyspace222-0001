package com.skyspace222.dao;

import java.util.List;

import com.skyspace222.dao.GenericDAO;
import com.skyspace222.domain.FlightCrew;





public interface FlightCrewDAO extends GenericDAO<FlightCrew, Integer> {
  
	List<FlightCrew> findAll();
	






}


