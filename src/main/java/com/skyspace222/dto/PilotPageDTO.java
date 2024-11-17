package com.skyspace222.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PilotPageDTO {

	private Integer page = 0;
	private Long totalElements = 0L;

	private List<PilotDTO> pilots;
}





