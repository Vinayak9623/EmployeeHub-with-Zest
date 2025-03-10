package com.employeeHub.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

	private Long id;
	private String name;
	private String email;
	private String department;
	private String position;
	private Double salary;
	private Date dateOfJoining;
}
