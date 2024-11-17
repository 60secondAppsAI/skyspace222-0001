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

import com.skyspace222.domain.FlightCabin;
import com.skyspace222.dto.FlightCabinDTO;
import com.skyspace222.dto.FlightCabinSearchDTO;
import com.skyspace222.dto.FlightCabinPageDTO;
import com.skyspace222.service.FlightCabinService;
import com.skyspace222.dto.common.RequestDTO;
import com.skyspace222.dto.common.ResultDTO;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;




@CrossOrigin(origins = "*")
@RequestMapping("/flightCabin")
@RestController
public class FlightCabinController {

	private final static Logger logger = LoggerFactory.getLogger(FlightCabinController.class);

	@Autowired
	FlightCabinService flightCabinService;



	@RequestMapping(value="/", method = RequestMethod.GET)
	public List<FlightCabin> getAll() {

		List<FlightCabin> flightCabins = flightCabinService.findAll();
		
		return flightCabins;	
	}

	@GetMapping(value = "/{flightCabinId}")
	@ResponseBody
	public FlightCabinDTO getFlightCabin(@PathVariable Integer flightCabinId) {
		
		return (flightCabinService.getFlightCabinDTOById(flightCabinId));
	}

 	@RequestMapping(value = "/addFlightCabin", method = RequestMethod.POST)
	public ResponseEntity<?> addFlightCabin(@RequestBody FlightCabinDTO flightCabinDTO, HttpServletRequest request) {

		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = flightCabinService.addFlightCabin(flightCabinDTO, requestDTO);
		
		return result.asResponseEntity();
	}

	@GetMapping("/flightCabins")
	public ResponseEntity<FlightCabinPageDTO> getFlightCabins(FlightCabinSearchDTO flightCabinSearchDTO) {
 
		return flightCabinService.getFlightCabins(flightCabinSearchDTO);
	}	

	@RequestMapping(value = "/updateFlightCabin", method = RequestMethod.POST)
	public ResponseEntity<?> updateFlightCabin(@RequestBody FlightCabinDTO flightCabinDTO, HttpServletRequest request) {
		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = flightCabinService.updateFlightCabin(flightCabinDTO, requestDTO);
		
//		if (result.isSuccessful()) {
//		}

		return result.asResponseEntity();
	}



}
