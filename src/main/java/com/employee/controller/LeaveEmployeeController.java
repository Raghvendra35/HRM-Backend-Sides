package com.employee.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.dao.EmployeeRepository;
import com.employee.dto.APIResponse;
import com.employee.entities.LeaveEmployee;
import com.employee.entities.ProjectDetails;
import com.employee.request.LeaveRequest;
import com.employee.service.LeaveEmployeeService;

@RestController
@RequestMapping("api/leaveemployee")
public class LeaveEmployeeController
{
	@Autowired
	private LeaveEmployeeService leaveEmployeeService;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	

	
	//Add Leave
	@PostMapping("")
	public ResponseEntity<LeaveEmployee> addLeave(@RequestBody LeaveRequest leaveEmployee)
	{
	  try
		{
		LeaveEmployee leaveEmp=this.leaveEmployeeService.addLeaveEmployee(leaveEmployee);
		return ResponseEntity.of(Optional.of(leaveEmp));
		}catch(Exception e)
		{
		  e.printStackTrace();
		  return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	//Get LeaveEmployee By Id
	@GetMapping("/{leaveId}")
	public ResponseEntity<Optional<LeaveEmployee>>  findLeaveById(@PathVariable ("leaveId") int leaveId)
	{
		
		Optional<LeaveEmployee> leaveEmp=this.leaveEmployeeService.getLeaveEmployeeById(leaveId);
		
		if(leaveEmp==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		else
		{
		return ResponseEntity.of(Optional.of(leaveEmp));
		}
		}
	
	 
   //Update Leave
  	@PutMapping("/{leaveId}")
  	public ResponseEntity<ProjectDetails> updateProjectById(@RequestBody LeaveEmployee leaveEmployee, @PathVariable ("leaveId") int leaveId)
  	{
  		try
  		{
  		leaveEmployeeService.updateLeave(leaveEmployee, leaveId);
  		return  ResponseEntity.ok(null);
  		}catch(Exception e)
  		{
  			e.printStackTrace();
  			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
  		}
  	}
  	
  	
   
  	//Delete Leave by Id
      @DeleteMapping("/{leaveId}")	
  	public ResponseEntity<LeaveEmployee> deleteProjectById(@PathVariable ("leaveId") int leaveId)
  	{
      	try
      	{
  		this.leaveEmployeeService.deleteLeaveEmployee(leaveId);
  		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
      	}catch(Exception e)
      	{
      		e.printStackTrace();
      		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
      	}
	
}
      
      
    //Get All LeaveEmployee
      @GetMapping("")
      public ResponseEntity<List<LeaveEmployee>> getAllLeave()
      {
   	 try
   	 {
   	  List<LeaveEmployee> list=leaveEmployeeService.getAllLeaveEmployee();
   	  return ResponseEntity.of(Optional.of(list));	
   	 }catch(Exception e)
   	 {
   		 e.printStackTrace();
   		 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
   	 }
   		   
      }
      
//      @GetMapping("/pagination")
//      public APIResponse<Page<LeaveEmployee>> getLeaveEmployeeWithPagination(Pageable page)
//      {
//    	Page<LeaveEmployee> pageLeave=leaveEmployeeService.getLeaveEmployeeWithPagination(page);
//    	  
//    	return new APIResponse<>(pageLeave.getSize(), pageLeave);
//      }
//      
      
      // OR
      
      @GetMapping("/pagination")
      public Page<LeaveEmployee> getLeaveEmployeeWithPage(Pageable page)
      {
    	  return this.leaveEmployeeService.getLeaveEmployeeWithPagination(page);
      }
      
      
}















