package com.skyspace222.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.skyspace222.domain.FlightCabin;
import com.skyspace222.dto.FlightCabinDTO;
import com.skyspace222.dto.FlightCabinSearchDTO;
import com.skyspace222.dto.FlightCabinPageDTO;
import com.skyspace222.dto.FlightCabinConvertCriteriaDTO;
import com.skyspace222.service.GenericService;
import com.skyspace222.dto.common.RequestDTO;
import com.skyspace222.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface FlightCabinService extends GenericService<FlightCabin, Integer> {

	List<FlightCabin> findAll();

	ResultDTO addFlightCabin(FlightCabinDTO flightCabinDTO, RequestDTO requestDTO);

	ResultDTO updateFlightCabin(FlightCabinDTO flightCabinDTO, RequestDTO requestDTO);

    Page<FlightCabin> getAllFlightCabins(Pageable pageable);

    Page<FlightCabin> getAllFlightCabins(Specification<FlightCabin> spec, Pageable pageable);

	ResponseEntity<FlightCabinPageDTO> getFlightCabins(FlightCabinSearchDTO flightCabinSearchDTO);
	
	List<FlightCabinDTO> convertFlightCabinsToFlightCabinDTOs(List<FlightCabin> flightCabins, FlightCabinConvertCriteriaDTO convertCriteria);

	FlightCabinDTO getFlightCabinDTOById(Integer flightCabinId);







}





