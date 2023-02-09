package com.employee.entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="employee")
public class Employee
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int    employeeId;
	private String  firstName,  lastName;
	private String  contact,  emailId;
	private String  aadharCard, panCard;
	private String  bankName,   accountNumber, cifNumber;
	private String  experience;
	private String  previousCompanyName;
	private String  designation;
	private String  password;
	private String  gender;     
	private LocalDate dateOfBirth;
	
	@OneToMany(cascade =CascadeType.ALL)
	private List<Address> address;

	
	@OneToMany(cascade =CascadeType.ALL)
	private List<Qualification> qualification; 	
	

	

//	@OneToOne(targetEntity = LeaveEmployee.class)
//	private LeaveEmployee leaveEmployee;
//
//	@OneToOne(targetEntity = ProjectDetails.class)
//    private ProjectDetails projectDetails;
//	
//	@OneToOne(targetEntity = AddSalary.class)
//	private AddSalary addSalary;
	
	
	






}













