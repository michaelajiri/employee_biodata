package com.employee.biodata.controller;

import com.employee.biodata.model.Employee;
import com.employee.biodata.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping(value = "/login")
	public String login() {
		return "login";
	}
	
	@GetMapping(value = "/register")
	public String register(ModelMap modelMap) {
		modelMap.put("employee", new Employee());
		return "register";
	}
	
	@PostMapping(value = "/register")
	public String createAccount(Employee employee) {
		employeeService.addEmployee(employee);
		return "redirect:/login";
	}
}