package com.skyspace222.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.skyspace222.domain.BoardingPass;
import com.skyspace222.dto.BoardingPassDTO;
import com.skyspace222.dto.BoardingPassSearchDTO;
import com.skyspace222.dto.BoardingPassPageDTO;
import com.skyspace222.dto.BoardingPassConvertCriteriaDTO;
import com.skyspace222.service.GenericService;
import com.skyspace222.dto.common.RequestDTO;
import com.skyspace222.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface BoardingPassService extends GenericService<BoardingPass, Integer> {

	List<BoardingPass> findAll();

	ResultDTO addBoardingPass(BoardingPassDTO boardingPassDTO, RequestDTO requestDTO);

	ResultDTO updateBoardingPass(BoardingPassDTO boardingPassDTO, RequestDTO requestDTO);

    Page<BoardingPass> getAllBoardingPasss(Pageable pageable);

    Page<BoardingPass> getAllBoardingPasss(Specification<BoardingPass> spec, Pageable pageable);

	ResponseEntity<BoardingPassPageDTO> getBoardingPasss(BoardingPassSearchDTO boardingPassSearchDTO);
	
	List<BoardingPassDTO> convertBoardingPasssToBoardingPassDTOs(List<BoardingPass> boardingPasss, BoardingPassConvertCriteriaDTO convertCriteria);

	BoardingPassDTO getBoardingPassDTOById(Integer boardingPassId);







}





