package com.skyspace222.dao;

import java.util.List;

import com.skyspace222.dao.GenericDAO;
import com.skyspace222.domain.BoardingPass;





public interface BoardingPassDAO extends GenericDAO<BoardingPass, Integer> {
  
	List<BoardingPass> findAll();
	






}


