package com.employeeHub.mapper;

import org.springframework.stereotype.Component;

import com.employeeHub.dto.EmployeeDto;
import com.employeeHub.entity.Employee;

@Component
public class EmployeeMapper {

	public EmployeeDto toDto(Employee employee) {

		return new EmployeeDto(employee.getId(), employee.getName(), employee.getEmail(), employee.getDepartment(),
				employee.getPosition(), employee.getSalary(), employee.getDateOfJoining());
	}

	public Employee toEntity(EmployeeDto employeeDto) {

		return new Employee(employeeDto.getId(), employeeDto.getName(), employeeDto.getEmail(),
				employeeDto.getDepartment(), employeeDto.getPosition(), employeeDto.getSalary(),
				employeeDto.getDateOfJoining()

		);

	}

}
