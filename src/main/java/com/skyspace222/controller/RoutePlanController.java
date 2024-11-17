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

import com.skyspace222.domain.RoutePlan;
import com.skyspace222.dto.RoutePlanDTO;
import com.skyspace222.dto.RoutePlanSearchDTO;
import com.skyspace222.dto.RoutePlanPageDTO;
import com.skyspace222.service.RoutePlanService;
import com.skyspace222.dto.common.RequestDTO;
import com.skyspace222.dto.common.ResultDTO;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;




@CrossOrigin(origins = "*")
@RequestMapping("/routePlan")
@RestController
public class RoutePlanController {

	private final static Logger logger = LoggerFactory.getLogger(RoutePlanController.class);

	@Autowired
	RoutePlanService routePlanService;



	@RequestMapping(value="/", method = RequestMethod.GET)
	public List<RoutePlan> getAll() {

		List<RoutePlan> routePlans = routePlanService.findAll();
		
		return routePlans;	
	}

	@GetMapping(value = "/{routePlanId}")
	@ResponseBody
	public RoutePlanDTO getRoutePlan(@PathVariable Integer routePlanId) {
		
		return (routePlanService.getRoutePlanDTOById(routePlanId));
	}

 	@RequestMapping(value = "/addRoutePlan", method = RequestMethod.POST)
	public ResponseEntity<?> addRoutePlan(@RequestBody RoutePlanDTO routePlanDTO, HttpServletRequest request) {

		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = routePlanService.addRoutePlan(routePlanDTO, requestDTO);
		
		return result.asResponseEntity();
	}

	@GetMapping("/routePlans")
	public ResponseEntity<RoutePlanPageDTO> getRoutePlans(RoutePlanSearchDTO routePlanSearchDTO) {
 
		return routePlanService.getRoutePlans(routePlanSearchDTO);
	}	

	@RequestMapping(value = "/updateRoutePlan", method = RequestMethod.POST)
	public ResponseEntity<?> updateRoutePlan(@RequestBody RoutePlanDTO routePlanDTO, HttpServletRequest request) {
		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = routePlanService.updateRoutePlan(routePlanDTO, requestDTO);
		
//		if (result.isSuccessful()) {
//		}

		return result.asResponseEntity();
	}



}
