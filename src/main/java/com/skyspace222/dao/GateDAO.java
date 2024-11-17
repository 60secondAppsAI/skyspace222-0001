package com.skyspace222.dao;

import java.util.List;

import com.skyspace222.dao.GenericDAO;
import com.skyspace222.domain.Gate;





public interface GateDAO extends GenericDAO<Gate, Integer> {
  
	List<Gate> findAll();
	






}


