package com.skyspace222.dao;

import java.util.List;

import com.skyspace222.dao.GenericDAO;
import com.skyspace222.domain.CrewMember;





public interface CrewMemberDAO extends GenericDAO<CrewMember, Integer> {
  
	List<CrewMember> findAll();
	






}


