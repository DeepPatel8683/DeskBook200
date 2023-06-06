package com.onerivet.deskbook.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onerivet.deskbook.models.entity.Employee;
import com.onerivet.deskbook.models.entity.SeatNumber;
import com.onerivet.deskbook.models.entity.SeatRequest;
import com.onerivet.deskbook.models.payload.RequestHistoryDto;
import com.onerivet.deskbook.repository.ColumnDetailsRepo;
import com.onerivet.deskbook.repository.EmployeeRepo;
import com.onerivet.deskbook.repository.FloorRepo;
import com.onerivet.deskbook.repository.SeatNumberRepo;
import com.onerivet.deskbook.repository.SeatRequestRepo;
import com.onerivet.deskbook.services.RequestHistoryService;

import jakarta.transaction.Transactional;


@Transactional
@Service
public class RequestHistoryImpl  implements RequestHistoryService{
	
	
	@Autowired
	private SeatRequestRepo seatRequestRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	

	@Override
	public List<RequestHistoryDto> getRequestHistory(int seatId) {
		
	//	return this.seatRequestRepo.findRequestHistoryById(id).stream().map((rh) -> this.modelMapper.map(rh, RequestHistoryDto.class)).collect(Collectors.toList());
		
		
		
		List<SeatRequest> sr =this.seatRequestRepo.findRequestHistoryById(new SeatNumber(seatId));
		
		
		RequestHistoryDto requestHistoryDto = new RequestHistoryDto();
		
		List<RequestHistoryDto> list = new ArrayList<>();
		
		
		for(int i=0; i< sr.size(); i++ ) {
			
			
			requestHistoryDto.setName(sr.get(i).getEmployee().getFirstName() + "" + sr.get(i).getEmployee().getLastName());
			requestHistoryDto.setDeskNo(sr.get(i).getSeatId().getColumn().getColumnName() + "" + sr.get(i).getSeatId().getSeatNumber());
			requestHistoryDto.setEmailId(sr.get(i).getEmployee().getEmailId());
			requestHistoryDto.setRequestFor(sr.get(i).getBookingDate());
			requestHistoryDto.setRequestDate(sr.get(i).getCreatedDate());
			requestHistoryDto.setFloorNo(sr.get(i).getSeatId().getColumn().getFloor().getId());
			requestHistoryDto.setStatus(sr.get(i).getRequestStatus());
			
			
			list.add(requestHistoryDto);
		}
		return list;
	}

}
