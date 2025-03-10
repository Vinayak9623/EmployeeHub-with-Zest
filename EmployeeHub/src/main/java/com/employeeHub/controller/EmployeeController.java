package com.employeeHub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.employeeHub.dto.EmployeeDto;
import com.employeeHub.serviceImpl.EmployeeServiceImpl;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl service;

	@PostMapping("/createEmployee")
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {

		EmployeeDto save =service.createEmployee(employeeDto);

		return ResponseEntity.status(HttpStatus.CREATED).body(save);
	}

	@GetMapping("/getAllEmployees")
	public ResponseEntity<List<EmployeeDto>> getAllEmployees() {

		List<EmployeeDto> employees = service.getAllEmployee();

		return ResponseEntity.status(HttpStatus.OK).body(employees);
	}

	@GetMapping("/getEmployeeById/{id}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long id) {

		EmployeeDto employeeById = service.getEmployeeById(id);

		return ResponseEntity.ok(employeeById);
	}

	@PutMapping("/updateEmployee/{id}")
	public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long id,
			@RequestBody EmployeeDto employeeDto) {

		EmployeeDto updateEmployee = service.updateEmployee(id, employeeDto);

		return ResponseEntity.ok(updateEmployee);

	}

	@DeleteMapping("/deleteEmployee/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable("id") Long id) {

		service.deleteEmployee(id);

		return ResponseEntity.noContent().build();
	}

}
