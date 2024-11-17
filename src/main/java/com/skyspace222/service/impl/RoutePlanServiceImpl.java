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
import com.skyspace222.dao.RoutePlanDAO;
import com.skyspace222.domain.RoutePlan;
import com.skyspace222.dto.RoutePlanDTO;
import com.skyspace222.dto.RoutePlanSearchDTO;
import com.skyspace222.dto.RoutePlanPageDTO;
import com.skyspace222.dto.RoutePlanConvertCriteriaDTO;
import com.skyspace222.dto.common.RequestDTO;
import com.skyspace222.dto.common.ResultDTO;
import com.skyspace222.service.RoutePlanService;
import com.skyspace222.util.ControllerUtils;





@Service
public class RoutePlanServiceImpl extends GenericServiceImpl<RoutePlan, Integer> implements RoutePlanService {

    private final static Logger logger = LoggerFactory.getLogger(RoutePlanServiceImpl.class);

	@Autowired
	RoutePlanDAO routePlanDao;

	


	@Override
	public GenericDAO<RoutePlan, Integer> getDAO() {
		return (GenericDAO<RoutePlan, Integer>) routePlanDao;
	}
	
	public List<RoutePlan> findAll () {
		List<RoutePlan> routePlans = routePlanDao.findAll();
		
		return routePlans;	
		
	}

	public ResultDTO addRoutePlan(RoutePlanDTO routePlanDTO, RequestDTO requestDTO) {

		RoutePlan routePlan = new RoutePlan();

		routePlan.setRoutePlanId(routePlanDTO.getRoutePlanId());


		LocalDate localDate = LocalDate.now();
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

		routePlan = routePlanDao.save(routePlan);
		
		ResultDTO result = new ResultDTO();
		return result;
	}
	
	public Page<RoutePlan> getAllRoutePlans(Pageable pageable) {
		return routePlanDao.findAll(pageable);
	}

	public Page<RoutePlan> getAllRoutePlans(Specification<RoutePlan> spec, Pageable pageable) {
		return routePlanDao.findAll(spec, pageable);
	}

	public ResponseEntity<RoutePlanPageDTO> getRoutePlans(RoutePlanSearchDTO routePlanSearchDTO) {
	
			Integer routePlanId = routePlanSearchDTO.getRoutePlanId(); 
 			String sortBy = routePlanSearchDTO.getSortBy();
			String sortOrder = routePlanSearchDTO.getSortOrder();
			String searchQuery = routePlanSearchDTO.getSearchQuery();
			Integer page = routePlanSearchDTO.getPage();
			Integer size = routePlanSearchDTO.getSize();

	        Specification<RoutePlan> spec = Specification.where(null);

			spec = ControllerUtils.andIfNecessary(spec, routePlanId, "routePlanId"); 
			

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

		Page<RoutePlan> routePlans = this.getAllRoutePlans(spec, pageable);
		
		//System.out.println(String.valueOf(routePlans.getTotalElements()) + " total ${classNamelPlural}, viewing page X of " + String.valueOf(routePlans.getTotalPages()));
		
		List<RoutePlan> routePlansList = routePlans.getContent();
		
		RoutePlanConvertCriteriaDTO convertCriteria = new RoutePlanConvertCriteriaDTO();
		List<RoutePlanDTO> routePlanDTOs = this.convertRoutePlansToRoutePlanDTOs(routePlansList,convertCriteria);
		
		RoutePlanPageDTO routePlanPageDTO = new RoutePlanPageDTO();
		routePlanPageDTO.setRoutePlans(routePlanDTOs);
		routePlanPageDTO.setTotalElements(routePlans.getTotalElements());
		return ResponseEntity.ok(routePlanPageDTO);
	}

	public List<RoutePlanDTO> convertRoutePlansToRoutePlanDTOs(List<RoutePlan> routePlans, RoutePlanConvertCriteriaDTO convertCriteria) {
		
		List<RoutePlanDTO> routePlanDTOs = new ArrayList<RoutePlanDTO>();
		
		for (RoutePlan routePlan : routePlans) {
			routePlanDTOs.add(convertRoutePlanToRoutePlanDTO(routePlan,convertCriteria));
		}
		
		return routePlanDTOs;

	}
	
	public RoutePlanDTO convertRoutePlanToRoutePlanDTO(RoutePlan routePlan, RoutePlanConvertCriteriaDTO convertCriteria) {
		
		RoutePlanDTO routePlanDTO = new RoutePlanDTO();
		
		routePlanDTO.setRoutePlanId(routePlan.getRoutePlanId());

	

		
		return routePlanDTO;
	}

	public ResultDTO updateRoutePlan(RoutePlanDTO routePlanDTO, RequestDTO requestDTO) {
		
		RoutePlan routePlan = routePlanDao.getById(routePlanDTO.getRoutePlanId());

		routePlan.setRoutePlanId(ControllerUtils.setValue(routePlan.getRoutePlanId(), routePlanDTO.getRoutePlanId()));



        routePlan = routePlanDao.save(routePlan);
		
		ResultDTO result = new ResultDTO();
		return result;
	}

	public RoutePlanDTO getRoutePlanDTOById(Integer routePlanId) {
	
		RoutePlan routePlan = routePlanDao.getById(routePlanId);
			
		
		RoutePlanConvertCriteriaDTO convertCriteria = new RoutePlanConvertCriteriaDTO();
		return(this.convertRoutePlanToRoutePlanDTO(routePlan,convertCriteria));
	}







}
