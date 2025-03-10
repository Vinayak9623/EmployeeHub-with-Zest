package com.employeeHub.service;

import java.util.List;

import com.employeeHub.dto.EmployeeDto;

public interface EmployeeService {

	EmployeeDto createEmployee(EmployeeDto employeeDto);

	List<EmployeeDto> getAllEmployee();

	EmployeeDto getEmployeeById(Long id);

	EmployeeDto updateEmployee(Long id, EmployeeDto newDetails);

	String deleteEmployee(Long id);

}
