package com.skyspace222.dao;

import java.util.List;

import com.skyspace222.dao.GenericDAO;
import com.skyspace222.domain.Seat;





public interface SeatDAO extends GenericDAO<Seat, Integer> {
  
	List<Seat> findAll();
	






}


