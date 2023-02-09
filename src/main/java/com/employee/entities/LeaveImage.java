package com.employee.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class LeaveImage 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int leaveId;
	private String name;
	private String imageType;
	private String filePath;
	

}
