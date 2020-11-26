package com.employee.biodata.controller;

import java.util.List;
import java.util.Optional;

import com.employee.biodata.model.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.employee.biodata.model.Employee;
import com.employee.biodata.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@Autowired
	PasswordEncoder passwordEncoder;

	@RequestMapping(value = "/api/employee/allEmployees", method = RequestMethod.GET)
	public String getAllEmployees(Model model){
		String username = "Admin";
		List<Employee> listOfEmployees = employeeService.getAllEmployees();
		model.addAttribute("listOfEmployees", listOfEmployees);
		model.addAttribute("username", username);
		return "employee";
	}

	@PostMapping(value = "/api/employee/saveUpdatedEmployee")
	public String saveUpdatedEmployee(@ModelAttribute("employee") Employee employee){

		String encodedPassword = passwordEncoder.encode(employee.getPassword());
		employee.setPassword(encodedPassword);

		Authority authority = new Authority();
		authority.setAuthority("ROLE_USER");
		authority.setEmployee(employee);

		employee.getAuthorities().add(authority);

		employeeService.saveUpdatedEmployee(employee);
		return "redirect:/api/employee/allEmployees";
	}

	@GetMapping("/api/employee/editEmployee/{id}")
	public String showFormUpdateForEmployee(@PathVariable ( value = "id") long id, Model model) {
		Employee employee = employeeService.getEmployeeById(id);
		model.addAttribute("employee", employee);
		return "edit_employee";
	}

	@RequestMapping(value = "/api/employee/deleteEmployee", method = {RequestMethod.GET, RequestMethod.DELETE})
	public String removeEmployee(long id){
		employeeService.removeEmployee(id);
		return "redirect:/api/employee/allEmployees";
	}
}