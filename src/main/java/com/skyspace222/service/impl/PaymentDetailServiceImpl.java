package com.skyspace222.service.impl;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;



import com.skyspace222.dao.GenericDAO;
import com.skyspace222.service.GenericService;
import com.skyspace222.service.impl.GenericServiceImpl;
import com.skyspace222.dao.PaymentDetailDAO;
import com.skyspace222.domain.PaymentDetail;
import com.skyspace222.dto.PaymentDetailDTO;
import com.skyspace222.dto.PaymentDetailSearchDTO;
import com.skyspace222.dto.PaymentDetailPageDTO;
import com.skyspace222.dto.PaymentDetailConvertCriteriaDTO;
import com.skyspace222.dto.common.RequestDTO;
import com.skyspace222.dto.common.ResultDTO;
import com.skyspace222.service.PaymentDetailService;
import com.skyspace222.util.ControllerUtils;





@Service
public class PaymentDetailServiceImpl extends GenericServiceImpl<PaymentDetail, Integer> implements PaymentDetailService {

    private final static Logger logger = LoggerFactory.getLogger(PaymentDetailServiceImpl.class);

	@Autowired
	PaymentDetailDAO paymentDetailDao;

	


	@Override
	public GenericDAO<PaymentDetail, Integer> getDAO() {
		return (GenericDAO<PaymentDetail, Integer>) paymentDetailDao;
	}
	
	public List<PaymentDetail> findAll () {
		List<PaymentDetail> paymentDetails = paymentDetailDao.findAll();
		
		return paymentDetails;	
		
	}

	public ResultDTO addPaymentDetail(PaymentDetailDTO paymentDetailDTO, RequestDTO requestDTO) {

		PaymentDetail paymentDetail = new PaymentDetail();

		paymentDetail.setPaymentDetailId(paymentDetailDTO.getPaymentDetailId());


		paymentDetail.setAmount(paymentDetailDTO.getAmount());


		paymentDetail.setPaymentDate(paymentDetailDTO.getPaymentDate());


		LocalDate localDate = LocalDate.now();
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

		paymentDetail = paymentDetailDao.save(paymentDetail);
		
		ResultDTO result = new ResultDTO();
		return result;
	}
	
	public Page<PaymentDetail> getAllPaymentDetails(Pageable pageable) {
		return paymentDetailDao.findAll(pageable);
	}

	public Page<PaymentDetail> getAllPaymentDetails(Specification<PaymentDetail> spec, Pageable pageable) {
		return paymentDetailDao.findAll(spec, pageable);
	}

	public ResponseEntity<PaymentDetailPageDTO> getPaymentDetails(PaymentDetailSearchDTO paymentDetailSearchDTO) {
	
			Integer paymentDetailId = paymentDetailSearchDTO.getPaymentDetailId(); 
    			String sortBy = paymentDetailSearchDTO.getSortBy();
			String sortOrder = paymentDetailSearchDTO.getSortOrder();
			String searchQuery = paymentDetailSearchDTO.getSearchQuery();
			Integer page = paymentDetailSearchDTO.getPage();
			Integer size = paymentDetailSearchDTO.getSize();

	        Specification<PaymentDetail> spec = Specification.where(null);

			spec = ControllerUtils.andIfNecessary(spec, paymentDetailId, "paymentDetailId"); 
			
			
 			

		if (searchQuery != null && !searchQuery.isEmpty()) {
			spec = spec.and((root, query, cb) -> cb.or(

		));}
		
		Sort sort = Sort.unsorted();
		if (sortBy != null && !sortBy.isEmpty() && sortOrder != null && !sortOrder.isEmpty()) {
			if (sortOrder.equalsIgnoreCase("asc")) {
				sort = Sort.by(sortBy).ascending();
			} else if (sortOrder.equalsIgnoreCase("desc")) {
				sort = Sort.by(sortBy).descending();
			}
		}
		Pageable pageable = PageRequest.of(page, size, sort);

		Page<PaymentDetail> paymentDetails = this.getAllPaymentDetails(spec, pageable);
		
		//System.out.println(String.valueOf(paymentDetails.getTotalElements()) + " total ${classNamelPlural}, viewing page X of " + String.valueOf(paymentDetails.getTotalPages()));
		
		List<PaymentDetail> paymentDetailsList = paymentDetails.getContent();
		
		PaymentDetailConvertCriteriaDTO convertCriteria = new PaymentDetailConvertCriteriaDTO();
		List<PaymentDetailDTO> paymentDetailDTOs = this.convertPaymentDetailsToPaymentDetailDTOs(paymentDetailsList,convertCriteria);
		
		PaymentDetailPageDTO paymentDetailPageDTO = new PaymentDetailPageDTO();
		paymentDetailPageDTO.setPaymentDetails(paymentDetailDTOs);
		paymentDetailPageDTO.setTotalElements(paymentDetails.getTotalElements());
		return ResponseEntity.ok(paymentDetailPageDTO);
	}

	public List<PaymentDetailDTO> convertPaymentDetailsToPaymentDetailDTOs(List<PaymentDetail> paymentDetails, PaymentDetailConvertCriteriaDTO convertCriteria) {
		
		List<PaymentDetailDTO> paymentDetailDTOs = new ArrayList<PaymentDetailDTO>();
		
		for (PaymentDetail paymentDetail : paymentDetails) {
			paymentDetailDTOs.add(convertPaymentDetailToPaymentDetailDTO(paymentDetail,convertCriteria));
		}
		
		return paymentDetailDTOs;

	}
	
	public PaymentDetailDTO convertPaymentDetailToPaymentDetailDTO(PaymentDetail paymentDetail, PaymentDetailConvertCriteriaDTO convertCriteria) {
		
		PaymentDetailDTO paymentDetailDTO = new PaymentDetailDTO();
		
		paymentDetailDTO.setPaymentDetailId(paymentDetail.getPaymentDetailId());

	
		paymentDetailDTO.setAmount(paymentDetail.getAmount());

	
		paymentDetailDTO.setPaymentDate(paymentDetail.getPaymentDate());

	

		
		return paymentDetailDTO;
	}

	public ResultDTO updatePaymentDetail(PaymentDetailDTO paymentDetailDTO, RequestDTO requestDTO) {
		
		PaymentDetail paymentDetail = paymentDetailDao.getById(paymentDetailDTO.getPaymentDetailId());

		paymentDetail.setPaymentDetailId(ControllerUtils.setValue(paymentDetail.getPaymentDetailId(), paymentDetailDTO.getPaymentDetailId()));

		paymentDetail.setAmount(ControllerUtils.setValue(paymentDetail.getAmount(), paymentDetailDTO.getAmount()));

		paymentDetail.setPaymentDate(ControllerUtils.setValue(paymentDetail.getPaymentDate(), paymentDetailDTO.getPaymentDate()));



        paymentDetail = paymentDetailDao.save(paymentDetail);
		
		ResultDTO result = new ResultDTO();
		return result;
	}

	public PaymentDetailDTO getPaymentDetailDTOById(Integer paymentDetailId) {
	
		PaymentDetail paymentDetail = paymentDetailDao.getById(paymentDetailId);
			
		
		PaymentDetailConvertCriteriaDTO convertCriteria = new PaymentDetailConvertCriteriaDTO();
		return(this.convertPaymentDetailToPaymentDetailDTO(paymentDetail,convertCriteria));
	}







}
