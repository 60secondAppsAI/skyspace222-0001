package com.skyspace222.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.skyspace222.domain.Pilot;
import com.skyspace222.dto.PilotDTO;
import com.skyspace222.dto.PilotSearchDTO;
import com.skyspace222.dto.PilotPageDTO;
import com.skyspace222.dto.PilotConvertCriteriaDTO;
import com.skyspace222.service.GenericService;
import com.skyspace222.dto.common.RequestDTO;
import com.skyspace222.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface PilotService extends GenericService<Pilot, Integer> {

	List<Pilot> findAll();

	ResultDTO addPilot(PilotDTO pilotDTO, RequestDTO requestDTO);

	ResultDTO updatePilot(PilotDTO pilotDTO, RequestDTO requestDTO);

    Page<Pilot> getAllPilots(Pageable pageable);

    Page<Pilot> getAllPilots(Specification<Pilot> spec, Pageable pageable);

	ResponseEntity<PilotPageDTO> getPilots(PilotSearchDTO pilotSearchDTO);
	
	List<PilotDTO> convertPilotsToPilotDTOs(List<Pilot> pilots, PilotConvertCriteriaDTO convertCriteria);

	PilotDTO getPilotDTOById(Integer pilotId);







}





