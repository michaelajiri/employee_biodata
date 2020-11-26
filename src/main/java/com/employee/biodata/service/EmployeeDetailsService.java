package com.employee.biodata.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.biodata.model.EmployeeDetails;
import com.employee.biodata.repository.EmployeeDetailsRepository;

@Service
public class EmployeeDetailsService {
	
	@Autowired
	EmployeeDetailsRepository employeeDetailsRepository;
	
	public List<EmployeeDetails> getEmployeeDetails(){
		return employeeDetailsRepository.findAll();	
	}
	
	public Optional<EmployeeDetails> getEmployeeDetailsById(Long id){
		return employeeDetailsRepository.findById(id);
	}
	
	public EmployeeDetails addEmployeeDetails(EmployeeDetails employeeDetails) {
		return employeeDetailsRepository.save(employeeDetails);
	}
	
	public void updateEmployeeDetails(EmployeeDetails employeeDetails) {
		employeeDetailsRepository.save(employeeDetails);
	}
	
	public void removeEmployeeDetails(Long id) {
		employeeDetailsRepository.deleteById(id);
	}
}