package com.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;

import com.employee.dao.EmployeeRepository;
import com.employee.dao.LeaveEmployeeRepository;
import com.employee.entities.Employee;
import com.employee.entities.LeaveEmployee;
import com.employee.entities.ProjectDetails;
import com.employee.request.LeaveRequest;

@Controller
public class LeaveEmployeeService
{
  
	@Autowired
	private LeaveEmployeeRepository leaveEmployeeRepository;
	@Autowired
	private EmployeeRepository employeeRepository;
	
	//Save LeaveEmployee
	public LeaveEmployee addLeaveEmployee(LeaveRequest leaveRequest)
	{
		Employee employee= employeeRepository.findById(leaveRequest.getEmployeeId()).get();
		
	    LeaveEmployee leave= new LeaveEmployee();
		
	    leave.setEmployee(employee);
		leave.setFromDate(leaveRequest.getFromDate());
		leave.setToDate(leaveRequest.getToDate());
		leave.setReasonToLeave(leaveRequest.getReasonToLeave());
				
		LeaveEmployee	 leaveEmp=this.leaveEmployeeRepository.save(leave);
		return leaveEmp;
	
	}
	
	
	//Get LeaveEmployee By Id
	public Optional<LeaveEmployee> getLeaveEmployeeById(int leaveId)
	{
	 Optional<LeaveEmployee>	leaveEmp=leaveEmployeeRepository.findById(leaveId);
		return leaveEmp;
	}
	
	
	
	
	
	//Get All Leave 
	public List<LeaveEmployee> getAllLeaveEmployee()
		{

		List<LeaveEmployee>	list=	(List<LeaveEmployee>) this.leaveEmployeeRepository.findAll();
		return list;
			
		}
	
	//Update the Leave  
	public void updateLeave(LeaveEmployee leaveEmp, int leaveId)
	{
		leaveEmp.setLeaveId(leaveId);
		leaveEmployeeRepository.save(leaveEmp);
		
	}
	
	
	//Delete The Project 
	public void deleteLeaveEmployee(int leaveId)
	{
		leaveEmployeeRepository.deleteById(leaveId);
		
	}
	
	//Pagination
	
	public Page<LeaveEmployee> getLeaveEmployeeWithPagination(Pageable page)
	{
		return leaveEmployeeRepository.findAll(page);
		
	}
	
	
	
}
