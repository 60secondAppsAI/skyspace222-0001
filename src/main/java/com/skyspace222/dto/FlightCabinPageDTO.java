package com.skyspace222.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class FlightCabinPageDTO {

	private Integer page = 0;
	private Long totalElements = 0L;

	private List<FlightCabinDTO> flightCabins;
}





