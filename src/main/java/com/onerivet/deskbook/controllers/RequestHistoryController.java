package com.onerivet.deskbook.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.onerivet.deskbook.models.payload.RequestHistoryDto;
import com.onerivet.deskbook.models.response.GenericResponse;
import com.onerivet.deskbook.services.RequestHistoryService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@Validated
@SecurityRequirement(name = "bearerAuth")
@RequestMapping("/api/deskbook")
public class RequestHistoryController {
	
	@Autowired
	private RequestHistoryService requestHistoryService;
	
	@GetMapping("/requesthistory")
	public GenericResponse<List<RequestHistoryDto>>  getReqestHistory(int seatId){
		GenericResponse<List<RequestHistoryDto>> genericResponse = new GenericResponse<>(this.requestHistoryService.getRequestHistory(seatId), null);
		return genericResponse;
		
		
	}
	

}
