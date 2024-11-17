package com.skyspace222.dao;

import java.util.List;

import com.skyspace222.dao.GenericDAO;
import com.skyspace222.domain.Booking;





public interface BookingDAO extends GenericDAO<Booking, Integer> {
  
	List<Booking> findAll();
	






}


