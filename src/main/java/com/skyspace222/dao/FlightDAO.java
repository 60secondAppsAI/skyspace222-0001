package com.skyspace222.dao;

import java.util.List;

import com.skyspace222.dao.GenericDAO;
import com.skyspace222.domain.Flight;





public interface FlightDAO extends GenericDAO<Flight, Integer> {
  
	List<Flight> findAll();
	






}


