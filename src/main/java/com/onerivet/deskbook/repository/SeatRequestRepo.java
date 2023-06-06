package com.onerivet.deskbook.repository;


import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.onerivet.deskbook.models.entity.Employee;
import com.onerivet.deskbook.models.entity.SeatNumber;
import com.onerivet.deskbook.models.entity.SeatRequest;
import com.onerivet.deskbook.models.payload.RequestHistoryDto;
import com.onerivet.deskbook.models.entity.SeatRequest;
public interface SeatRequestRepo extends JpaRepository<SeatRequest, Integer> {
	
	
	
//	@Query(value = "SELECT  \n"
//			+ "    CONCAT(E.firstName, ' ', E.lastName) AS Name,\n"
//			+ "    CAST(SR.createdDate AS DATE) AS RequestDate,\n"
//			+ "    SR.bookingDate AS RequestedFor,\n"
//			+ "    E.emailId,\n"
//			+ "    CASE\n"
//			+ "        WHEN F.floorName = '1st Floor' THEN 1\n"
//			+ "        WHEN F.floorName = '2nd Floor' THEN 2\n"
//			+ "        WHEN F.floorName = '3rd Floor' THEN 3\n"
//			+ "        WHEN F.floorName = '4th Floor' THEN 4\n"
//			+ "    END AS floorNo,\n"
//			+ "    CONCAT(CL.columnName, S.seatNumber) AS deskNo,\n"
//			+ "    CASE\n"
//			+ "        WHEN SR.requestStatus = 1 THEN 'Take Action'\n"
//			+ "        WHEN SR.requestStatus = 2 THEN 'Accepted'\n"
//			+ "        WHEN SR.requestStatus = 3 THEN 'Reject'\n"
//			+ "        WHEN SR.requestStatus = 4 THEN 'Canceled'\n"
//			+ "    END AS status\n"
//			+ "FROM SeatRequest SR\n"
//			+ "LEFT JOIN SR.employee E\n"
//			+ "LEFT JOIN SR.seat S\n"
//			+ "LEFT JOIN S.column CL\n"
//			+ "LEFT JOIN CL.floor F\n"
//			+ "WHERE E.employeeId =:employeeId")
	public List<RequestHistoryDto> findRequestHiById(String  EmployeeId);
	
	@Query(value = "SELECT sr FROM SeatRequest sr WHERE sr.seatNumber =:seatNumber")
	public List<SeatRequest> findRequestHistoryById(SeatNumber seatNumber);

}
