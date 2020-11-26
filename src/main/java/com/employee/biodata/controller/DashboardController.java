package com.employee.biodata.controller;

import com.employee.biodata.model.Employee;
import com.employee.biodata.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DashboardController {

	@Autowired
	EmployeeRepository employeeRepository;

	@GetMapping(value = "/")
	public String homePage() {
		return "index";
	}
	
	@GetMapping(value = "/dashboard")
	public String dashboard(@AuthenticationPrincipal Employee employee, ModelMap modelMap) {
		List<Employee> listOfEmployees = employeeRepository.findAll();

		modelMap.put("listOfEmployees", listOfEmployees);
		
		return "dashboard";
	}
}