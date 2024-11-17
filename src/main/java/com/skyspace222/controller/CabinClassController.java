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

import com.skyspace222.domain.CabinClass;
import com.skyspace222.dto.CabinClassDTO;
import com.skyspace222.dto.CabinClassSearchDTO;
import com.skyspace222.dto.CabinClassPageDTO;
import com.skyspace222.service.CabinClassService;
import com.skyspace222.dto.common.RequestDTO;
import com.skyspace222.dto.common.ResultDTO;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;




@CrossOrigin(origins = "*")
@RequestMapping("/cabinClass")
@RestController
public class CabinClassController {

	private final static Logger logger = LoggerFactory.getLogger(CabinClassController.class);

	@Autowired
	CabinClassService cabinClassService;



	@RequestMapping(value="/", method = RequestMethod.GET)
	public List<CabinClass> getAll() {

		List<CabinClass> cabinClasss = cabinClassService.findAll();
		
		return cabinClasss;	
	}

	@GetMapping(value = "/{cabinClassId}")
	@ResponseBody
	public CabinClassDTO getCabinClass(@PathVariable Integer cabinClassId) {
		
		return (cabinClassService.getCabinClassDTOById(cabinClassId));
	}

 	@RequestMapping(value = "/addCabinClass", method = RequestMethod.POST)
	public ResponseEntity<?> addCabinClass(@RequestBody CabinClassDTO cabinClassDTO, HttpServletRequest request) {

		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = cabinClassService.addCabinClass(cabinClassDTO, requestDTO);
		
		return result.asResponseEntity();
	}

	@GetMapping("/cabinClasss")
	public ResponseEntity<CabinClassPageDTO> getCabinClasss(CabinClassSearchDTO cabinClassSearchDTO) {
 
		return cabinClassService.getCabinClasss(cabinClassSearchDTO);
	}	

	@RequestMapping(value = "/updateCabinClass", method = RequestMethod.POST)
	public ResponseEntity<?> updateCabinClass(@RequestBody CabinClassDTO cabinClassDTO, HttpServletRequest request) {
		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = cabinClassService.updateCabinClass(cabinClassDTO, requestDTO);
		
//		if (result.isSuccessful()) {
//		}

		return result.asResponseEntity();
	}



}
