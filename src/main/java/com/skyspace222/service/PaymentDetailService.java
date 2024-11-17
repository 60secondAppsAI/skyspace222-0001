package com.skyspace222.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.skyspace222.domain.PaymentDetail;
import com.skyspace222.dto.PaymentDetailDTO;
import com.skyspace222.dto.PaymentDetailSearchDTO;
import com.skyspace222.dto.PaymentDetailPageDTO;
import com.skyspace222.dto.PaymentDetailConvertCriteriaDTO;
import com.skyspace222.service.GenericService;
import com.skyspace222.dto.common.RequestDTO;
import com.skyspace222.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface PaymentDetailService extends GenericService<PaymentDetail, Integer> {

	List<PaymentDetail> findAll();

	ResultDTO addPaymentDetail(PaymentDetailDTO paymentDetailDTO, RequestDTO requestDTO);

	ResultDTO updatePaymentDetail(PaymentDetailDTO paymentDetailDTO, RequestDTO requestDTO);

    Page<PaymentDetail> getAllPaymentDetails(Pageable pageable);

    Page<PaymentDetail> getAllPaymentDetails(Specification<PaymentDetail> spec, Pageable pageable);

	ResponseEntity<PaymentDetailPageDTO> getPaymentDetails(PaymentDetailSearchDTO paymentDetailSearchDTO);
	
	List<PaymentDetailDTO> convertPaymentDetailsToPaymentDetailDTOs(List<PaymentDetail> paymentDetails, PaymentDetailConvertCriteriaDTO convertCriteria);

	PaymentDetailDTO getPaymentDetailDTOById(Integer paymentDetailId);







}





