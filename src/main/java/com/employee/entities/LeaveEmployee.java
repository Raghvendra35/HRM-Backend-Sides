package com.employee.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class LeaveEmployee
{
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
     private int leaveId;
     private LocalDate fromDate;
     private LocalDate toDate;
     private String reasonToLeave;
	
    
    
     @OneToOne(targetEntity = Employee.class)
     private Employee employee;



	public LeaveEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}



	public LeaveEmployee(int leaveId, LocalDate fromDate, LocalDate toDate, String reasonToLeave, Employee employee) {
		super();
		this.leaveId = leaveId;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.reasonToLeave = reasonToLeave;
		this.employee = employee;
	}



	public int getLeaveId() {
		return leaveId;
	}



	public void setLeaveId(int leaveId) {
		this.leaveId = leaveId;
	}



	public LocalDate getFromDate() {
		return fromDate;
	}



	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}



	public LocalDate getToDate() {
		return toDate;
	}



	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}



	public String getReasonToLeave() {
		return reasonToLeave;
	}



	public void setReasonToLeave(String reasonToLeave) {
		this.reasonToLeave = reasonToLeave;
	}



	public Employee getEmployee() {
		return employee;
	}



	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


    
     
}
