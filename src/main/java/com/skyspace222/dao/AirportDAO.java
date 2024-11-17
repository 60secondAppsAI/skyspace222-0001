package com.skyspace222.dao;

import java.util.List;

import com.skyspace222.dao.GenericDAO;
import com.skyspace222.domain.Airport;





public interface AirportDAO extends GenericDAO<Airport, Integer> {
  
	List<Airport> findAll();
	






}


