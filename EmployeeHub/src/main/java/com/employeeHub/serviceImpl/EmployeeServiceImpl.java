package com.employeeHub.serviceImpl;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.employeeHub.dto.EmployeeDto;
import com.employeeHub.entity.Employee;
import com.employeeHub.exception.ResourceNotFoundException;
import com.employeeHub.mapper.EmployeeMapper;
import com.employeeHub.repository.EmployeeRepository;
import com.employeeHub.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private EmployeeMapper mapper;

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {

		Employee employee = mapper.toEntity(employeeDto);

		Employee save = employeeRepository.save(employee);

		return mapper.toDto(save);
	}

	@Override
	public List<EmployeeDto> getAllEmployee() {

		return employeeRepository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());

	}

	@Override
	public EmployeeDto getEmployeeById(Long id) {

		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee Not Found "));
		return mapper.toDto(employee);
	}

	@Override
	public EmployeeDto updateEmployee(Long id, EmployeeDto newDetails) {

		Employee existingEmployee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee Not found"));

		existingEmployee.setName(newDetails.getName());
		existingEmployee.setEmail(newDetails.getEmail());
		existingEmployee.setDepartment(newDetails.getDepartment());
		existingEmployee.setPosition(newDetails.getPosition());
		existingEmployee.setSalary(newDetails.getSalary());
		existingEmployee.setDateOfJoining(newDetails.getDateOfJoining());

		Employee update = employeeRepository.save(existingEmployee);

		return mapper.toDto(update);

	}

	@Override
	public String deleteEmployee(Long id) {

		employeeRepository.deleteById(id);
		return "Employee Deleted";
	}
	
	
	

}
