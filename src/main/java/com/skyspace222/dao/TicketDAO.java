package com.skyspace222.dao;

import java.util.List;

import com.skyspace222.dao.GenericDAO;
import com.skyspace222.domain.Ticket;





public interface TicketDAO extends GenericDAO<Ticket, Integer> {
  
	List<Ticket> findAll();
	






}


