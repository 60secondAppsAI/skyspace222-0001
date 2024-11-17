package com.skyspace222.dao;

import java.util.List;

import com.skyspace222.dao.GenericDAO;
import com.skyspace222.domain.FlightCabin;





public interface FlightCabinDAO extends GenericDAO<FlightCabin, Integer> {
  
	List<FlightCabin> findAll();
	






}


