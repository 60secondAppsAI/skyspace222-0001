package com.skyspace222.controller;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;
import java.util.ArrayList;


import com.skyspace222.util.Util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.Timestamp;
import java.util.Date;

import com.skyspace222.domain.PaymentDetail;
import com.skyspace222.dto.PaymentDetailDTO;
import com.skyspace222.dto.PaymentDetailSearchDTO;
import com.skyspace222.dto.PaymentDetailPageDTO;
import com.skyspace222.service.PaymentDetailService;
import com.skyspace222.dto.common.RequestDTO;
import com.skyspace222.dto.common.ResultDTO;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;




@CrossOrigin(origins = "*")
@RequestMapping("/paymentDetail")
@RestController
public class PaymentDetailController {

	private final static Logger logger = LoggerFactory.getLogger(PaymentDetailController.class);

	@Autowired
	PaymentDetailService paymentDetailService;



	@RequestMapping(value="/", method = RequestMethod.GET)
	public List<PaymentDetail> getAll() {

		List<PaymentDetail> paymentDetails = paymentDetailService.findAll();
		
		return paymentDetails;	
	}

	@GetMapping(value = "/{paymentDetailId}")
	@ResponseBody
	public PaymentDetailDTO getPaymentDetail(@PathVariable Integer paymentDetailId) {
		
		return (paymentDetailService.getPaymentDetailDTOById(paymentDetailId));
	}

 	@RequestMapping(value = "/addPaymentDetail", method = RequestMethod.POST)
	public ResponseEntity<?> addPaymentDetail(@RequestBody PaymentDetailDTO paymentDetailDTO, HttpServletRequest request) {

		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = paymentDetailService.addPaymentDetail(paymentDetailDTO, requestDTO);
		
		return result.asResponseEntity();
	}

	@GetMapping("/paymentDetails")
	public ResponseEntity<PaymentDetailPageDTO> getPaymentDetails(PaymentDetailSearchDTO paymentDetailSearchDTO) {
 
		return paymentDetailService.getPaymentDetails(paymentDetailSearchDTO);
	}	

	@RequestMapping(value = "/updatePaymentDetail", method = RequestMethod.POST)
	public ResponseEntity<?> updatePaymentDetail(@RequestBody PaymentDetailDTO paymentDetailDTO, HttpServletRequest request) {
		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = paymentDetailService.updatePaymentDetail(paymentDetailDTO, requestDTO);
		
//		if (result.isSuccessful()) {
//		}

		return result.asResponseEntity();
	}



}
