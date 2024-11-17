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
import com.skyspace222.dao.FlightCabinDAO;
import com.skyspace222.domain.FlightCabin;
import com.skyspace222.dto.FlightCabinDTO;
import com.skyspace222.dto.FlightCabinSearchDTO;
import com.skyspace222.dto.FlightCabinPageDTO;
import com.skyspace222.dto.FlightCabinConvertCriteriaDTO;
import com.skyspace222.dto.common.RequestDTO;
import com.skyspace222.dto.common.ResultDTO;
import com.skyspace222.service.FlightCabinService;
import com.skyspace222.util.ControllerUtils;





@Service
public class FlightCabinServiceImpl extends GenericServiceImpl<FlightCabin, Integer> implements FlightCabinService {

    private final static Logger logger = LoggerFactory.getLogger(FlightCabinServiceImpl.class);

	@Autowired
	FlightCabinDAO flightCabinDao;

	


	@Override
	public GenericDAO<FlightCabin, Integer> getDAO() {
		return (GenericDAO<FlightCabin, Integer>) flightCabinDao;
	}
	
	public List<FlightCabin> findAll () {
		List<FlightCabin> flightCabins = flightCabinDao.findAll();
		
		return flightCabins;	
		
	}

	public ResultDTO addFlightCabin(FlightCabinDTO flightCabinDTO, RequestDTO requestDTO) {

		FlightCabin flightCabin = new FlightCabin();

		flightCabin.setFlightCabinId(flightCabinDTO.getFlightCabinId());


		LocalDate localDate = LocalDate.now();
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

		flightCabin = flightCabinDao.save(flightCabin);
		
		ResultDTO result = new ResultDTO();
		return result;
	}
	
	public Page<FlightCabin> getAllFlightCabins(Pageable pageable) {
		return flightCabinDao.findAll(pageable);
	}

	public Page<FlightCabin> getAllFlightCabins(Specification<FlightCabin> spec, Pageable pageable) {
		return flightCabinDao.findAll(spec, pageable);
	}

	public ResponseEntity<FlightCabinPageDTO> getFlightCabins(FlightCabinSearchDTO flightCabinSearchDTO) {
	
			Integer flightCabinId = flightCabinSearchDTO.getFlightCabinId(); 
 			String sortBy = flightCabinSearchDTO.getSortBy();
			String sortOrder = flightCabinSearchDTO.getSortOrder();
			String searchQuery = flightCabinSearchDTO.getSearchQuery();
			Integer page = flightCabinSearchDTO.getPage();
			Integer size = flightCabinSearchDTO.getSize();

	        Specification<FlightCabin> spec = Specification.where(null);

			spec = ControllerUtils.andIfNecessary(spec, flightCabinId, "flightCabinId"); 
			

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

		Page<FlightCabin> flightCabins = this.getAllFlightCabins(spec, pageable);
		
		//System.out.println(String.valueOf(flightCabins.getTotalElements()) + " total ${classNamelPlural}, viewing page X of " + String.valueOf(flightCabins.getTotalPages()));
		
		List<FlightCabin> flightCabinsList = flightCabins.getContent();
		
		FlightCabinConvertCriteriaDTO convertCriteria = new FlightCabinConvertCriteriaDTO();
		List<FlightCabinDTO> flightCabinDTOs = this.convertFlightCabinsToFlightCabinDTOs(flightCabinsList,convertCriteria);
		
		FlightCabinPageDTO flightCabinPageDTO = new FlightCabinPageDTO();
		flightCabinPageDTO.setFlightCabins(flightCabinDTOs);
		flightCabinPageDTO.setTotalElements(flightCabins.getTotalElements());
		return ResponseEntity.ok(flightCabinPageDTO);
	}

	public List<FlightCabinDTO> convertFlightCabinsToFlightCabinDTOs(List<FlightCabin> flightCabins, FlightCabinConvertCriteriaDTO convertCriteria) {
		
		List<FlightCabinDTO> flightCabinDTOs = new ArrayList<FlightCabinDTO>();
		
		for (FlightCabin flightCabin : flightCabins) {
			flightCabinDTOs.add(convertFlightCabinToFlightCabinDTO(flightCabin,convertCriteria));
		}
		
		return flightCabinDTOs;

	}
	
	public FlightCabinDTO convertFlightCabinToFlightCabinDTO(FlightCabin flightCabin, FlightCabinConvertCriteriaDTO convertCriteria) {
		
		FlightCabinDTO flightCabinDTO = new FlightCabinDTO();
		
		flightCabinDTO.setFlightCabinId(flightCabin.getFlightCabinId());

	

		
		return flightCabinDTO;
	}

	public ResultDTO updateFlightCabin(FlightCabinDTO flightCabinDTO, RequestDTO requestDTO) {
		
		FlightCabin flightCabin = flightCabinDao.getById(flightCabinDTO.getFlightCabinId());

		flightCabin.setFlightCabinId(ControllerUtils.setValue(flightCabin.getFlightCabinId(), flightCabinDTO.getFlightCabinId()));



        flightCabin = flightCabinDao.save(flightCabin);
		
		ResultDTO result = new ResultDTO();
		return result;
	}

	public FlightCabinDTO getFlightCabinDTOById(Integer flightCabinId) {
	
		FlightCabin flightCabin = flightCabinDao.getById(flightCabinId);
			
		
		FlightCabinConvertCriteriaDTO convertCriteria = new FlightCabinConvertCriteriaDTO();
		return(this.convertFlightCabinToFlightCabinDTO(flightCabin,convertCriteria));
	}







}
