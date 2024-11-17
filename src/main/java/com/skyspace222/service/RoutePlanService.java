package com.skyspace222.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.skyspace222.domain.RoutePlan;
import com.skyspace222.dto.RoutePlanDTO;
import com.skyspace222.dto.RoutePlanSearchDTO;
import com.skyspace222.dto.RoutePlanPageDTO;
import com.skyspace222.dto.RoutePlanConvertCriteriaDTO;
import com.skyspace222.service.GenericService;
import com.skyspace222.dto.common.RequestDTO;
import com.skyspace222.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface RoutePlanService extends GenericService<RoutePlan, Integer> {

	List<RoutePlan> findAll();

	ResultDTO addRoutePlan(RoutePlanDTO routePlanDTO, RequestDTO requestDTO);

	ResultDTO updateRoutePlan(RoutePlanDTO routePlanDTO, RequestDTO requestDTO);

    Page<RoutePlan> getAllRoutePlans(Pageable pageable);

    Page<RoutePlan> getAllRoutePlans(Specification<RoutePlan> spec, Pageable pageable);

	ResponseEntity<RoutePlanPageDTO> getRoutePlans(RoutePlanSearchDTO routePlanSearchDTO);
	
	List<RoutePlanDTO> convertRoutePlansToRoutePlanDTOs(List<RoutePlan> routePlans, RoutePlanConvertCriteriaDTO convertCriteria);

	RoutePlanDTO getRoutePlanDTOById(Integer routePlanId);







}





