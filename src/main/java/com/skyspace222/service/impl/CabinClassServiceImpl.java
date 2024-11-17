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
import com.skyspace222.dao.CabinClassDAO;
import com.skyspace222.domain.CabinClass;
import com.skyspace222.dto.CabinClassDTO;
import com.skyspace222.dto.CabinClassSearchDTO;
import com.skyspace222.dto.CabinClassPageDTO;
import com.skyspace222.dto.CabinClassConvertCriteriaDTO;
import com.skyspace222.dto.common.RequestDTO;
import com.skyspace222.dto.common.ResultDTO;
import com.skyspace222.service.CabinClassService;
import com.skyspace222.util.ControllerUtils;





@Service
public class CabinClassServiceImpl extends GenericServiceImpl<CabinClass, Integer> implements CabinClassService {

    private final static Logger logger = LoggerFactory.getLogger(CabinClassServiceImpl.class);

	@Autowired
	CabinClassDAO cabinClassDao;

	


	@Override
	public GenericDAO<CabinClass, Integer> getDAO() {
		return (GenericDAO<CabinClass, Integer>) cabinClassDao;
	}
	
	public List<CabinClass> findAll () {
		List<CabinClass> cabinClasss = cabinClassDao.findAll();
		
		return cabinClasss;	
		
	}

	public ResultDTO addCabinClass(CabinClassDTO cabinClassDTO, RequestDTO requestDTO) {

		CabinClass cabinClass = new CabinClass();

		cabinClass.setCabinClassId(cabinClassDTO.getCabinClassId());


		cabinClass.setName(cabinClassDTO.getName());


		cabinClass.setDescription(cabinClassDTO.getDescription());


		LocalDate localDate = LocalDate.now();
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

		cabinClass = cabinClassDao.save(cabinClass);
		
		ResultDTO result = new ResultDTO();
		return result;
	}
	
	public Page<CabinClass> getAllCabinClasss(Pageable pageable) {
		return cabinClassDao.findAll(pageable);
	}

	public Page<CabinClass> getAllCabinClasss(Specification<CabinClass> spec, Pageable pageable) {
		return cabinClassDao.findAll(spec, pageable);
	}

	public ResponseEntity<CabinClassPageDTO> getCabinClasss(CabinClassSearchDTO cabinClassSearchDTO) {
	
			Integer cabinClassId = cabinClassSearchDTO.getCabinClassId(); 
 			String name = cabinClassSearchDTO.getName(); 
 			String description = cabinClassSearchDTO.getDescription(); 
 			String sortBy = cabinClassSearchDTO.getSortBy();
			String sortOrder = cabinClassSearchDTO.getSortOrder();
			String searchQuery = cabinClassSearchDTO.getSearchQuery();
			Integer page = cabinClassSearchDTO.getPage();
			Integer size = cabinClassSearchDTO.getSize();

	        Specification<CabinClass> spec = Specification.where(null);

			spec = ControllerUtils.andIfNecessary(spec, cabinClassId, "cabinClassId"); 
			
			spec = ControllerUtils.andIfNecessary(spec, name, "name"); 
			
			spec = ControllerUtils.andIfNecessary(spec, description, "description"); 
			

		if (searchQuery != null && !searchQuery.isEmpty()) {
			spec = spec.and((root, query, cb) -> cb.or(

             cb.like(cb.lower(root.get("name")), "%" + searchQuery.toLowerCase() + "%") 
             , cb.like(cb.lower(root.get("description")), "%" + searchQuery.toLowerCase() + "%") 
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

		Page<CabinClass> cabinClasss = this.getAllCabinClasss(spec, pageable);
		
		//System.out.println(String.valueOf(cabinClasss.getTotalElements()) + " total ${classNamelPlural}, viewing page X of " + String.valueOf(cabinClasss.getTotalPages()));
		
		List<CabinClass> cabinClasssList = cabinClasss.getContent();
		
		CabinClassConvertCriteriaDTO convertCriteria = new CabinClassConvertCriteriaDTO();
		List<CabinClassDTO> cabinClassDTOs = this.convertCabinClasssToCabinClassDTOs(cabinClasssList,convertCriteria);
		
		CabinClassPageDTO cabinClassPageDTO = new CabinClassPageDTO();
		cabinClassPageDTO.setCabinClasss(cabinClassDTOs);
		cabinClassPageDTO.setTotalElements(cabinClasss.getTotalElements());
		return ResponseEntity.ok(cabinClassPageDTO);
	}

	public List<CabinClassDTO> convertCabinClasssToCabinClassDTOs(List<CabinClass> cabinClasss, CabinClassConvertCriteriaDTO convertCriteria) {
		
		List<CabinClassDTO> cabinClassDTOs = new ArrayList<CabinClassDTO>();
		
		for (CabinClass cabinClass : cabinClasss) {
			cabinClassDTOs.add(convertCabinClassToCabinClassDTO(cabinClass,convertCriteria));
		}
		
		return cabinClassDTOs;

	}
	
	public CabinClassDTO convertCabinClassToCabinClassDTO(CabinClass cabinClass, CabinClassConvertCriteriaDTO convertCriteria) {
		
		CabinClassDTO cabinClassDTO = new CabinClassDTO();
		
		cabinClassDTO.setCabinClassId(cabinClass.getCabinClassId());

	
		cabinClassDTO.setName(cabinClass.getName());

	
		cabinClassDTO.setDescription(cabinClass.getDescription());

	

		
		return cabinClassDTO;
	}

	public ResultDTO updateCabinClass(CabinClassDTO cabinClassDTO, RequestDTO requestDTO) {
		
		CabinClass cabinClass = cabinClassDao.getById(cabinClassDTO.getCabinClassId());

		cabinClass.setCabinClassId(ControllerUtils.setValue(cabinClass.getCabinClassId(), cabinClassDTO.getCabinClassId()));

		cabinClass.setName(ControllerUtils.setValue(cabinClass.getName(), cabinClassDTO.getName()));

		cabinClass.setDescription(ControllerUtils.setValue(cabinClass.getDescription(), cabinClassDTO.getDescription()));



        cabinClass = cabinClassDao.save(cabinClass);
		
		ResultDTO result = new ResultDTO();
		return result;
	}

	public CabinClassDTO getCabinClassDTOById(Integer cabinClassId) {
	
		CabinClass cabinClass = cabinClassDao.getById(cabinClassId);
			
		
		CabinClassConvertCriteriaDTO convertCriteria = new CabinClassConvertCriteriaDTO();
		return(this.convertCabinClassToCabinClassDTO(cabinClass,convertCriteria));
	}







}
