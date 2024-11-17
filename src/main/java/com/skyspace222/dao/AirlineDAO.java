package com.skyspace222.dao;

import java.util.List;

import com.skyspace222.dao.GenericDAO;
import com.skyspace222.domain.Airline;





public interface AirlineDAO extends GenericDAO<Airline, Integer> {
  
	List<Airline> findAll();
	






}


