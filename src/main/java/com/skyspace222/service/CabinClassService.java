package com.skyspace222.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.skyspace222.domain.CabinClass;
import com.skyspace222.dto.CabinClassDTO;
import com.skyspace222.dto.CabinClassSearchDTO;
import com.skyspace222.dto.CabinClassPageDTO;
import com.skyspace222.dto.CabinClassConvertCriteriaDTO;
import com.skyspace222.service.GenericService;
import com.skyspace222.dto.common.RequestDTO;
import com.skyspace222.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface CabinClassService extends GenericService<CabinClass, Integer> {

	List<CabinClass> findAll();

	ResultDTO addCabinClass(CabinClassDTO cabinClassDTO, RequestDTO requestDTO);

	ResultDTO updateCabinClass(CabinClassDTO cabinClassDTO, RequestDTO requestDTO);

    Page<CabinClass> getAllCabinClasss(Pageable pageable);

    Page<CabinClass> getAllCabinClasss(Specification<CabinClass> spec, Pageable pageable);

	ResponseEntity<CabinClassPageDTO> getCabinClasss(CabinClassSearchDTO cabinClassSearchDTO);
	
	List<CabinClassDTO> convertCabinClasssToCabinClassDTOs(List<CabinClass> cabinClasss, CabinClassConvertCriteriaDTO convertCriteria);

	CabinClassDTO getCabinClassDTOById(Integer cabinClassId);







}





