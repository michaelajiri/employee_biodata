package com.employee.biodata.service;

import java.util.List;
import java.util.Optional;

import com.employee.biodata.model.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.employee.biodata.model.Employee;
import com.employee.biodata.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	public List<Employee> getAllEmployees() {
		return (List<Employee>) employeeRepository.findAll();
	}

	public Employee getEmployeeById(long id) {
		Optional<Employee> optional = employeeRepository.findById(id);
		Employee employee = null;
		if (optional.isPresent()) {
			employee = optional.get();
		} else {
			throw new RuntimeException(" Employee not found for id :: " + id);
		}
		return employee;
	}

	public void saveUpdatedEmployee(Employee employee){
		employeeRepository.save(employee);
	}

	public Employee addEmployee(Employee employee) {
		String encodedPassword = passwordEncoder.encode(employee.getPassword());
		employee.setPassword(encodedPassword);

		Authority authority = new Authority();
		authority.setAuthority("ROLE_USER");
		authority.setEmployee(employee);

		employee.getAuthorities().add(authority);

		return employeeRepository.save(employee);
	}

	public void removeEmployee(long id){
		employeeRepository.deleteById(id);
	}
}