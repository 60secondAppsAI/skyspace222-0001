package com.skyspace222.dao;

import java.util.List;

import com.skyspace222.dao.GenericDAO;
import com.skyspace222.domain.Passenger;





public interface PassengerDAO extends GenericDAO<Passenger, Integer> {
  
	List<Passenger> findAll();
	






}


