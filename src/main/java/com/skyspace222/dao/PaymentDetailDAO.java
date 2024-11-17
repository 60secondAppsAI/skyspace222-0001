package com.skyspace222.dao;

import java.util.List;

import com.skyspace222.dao.GenericDAO;
import com.skyspace222.domain.PaymentDetail;





public interface PaymentDetailDAO extends GenericDAO<PaymentDetail, Integer> {
  
	List<PaymentDetail> findAll();
	






}


