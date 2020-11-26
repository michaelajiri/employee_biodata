package com.employee.biodata.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.employee.biodata.service.EmployeeDetailsService;

@Controller
public class EmployeeDetailsController {

	@Autowired
	EmployeeDetailsService employeeDetailsService;


//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String getEmployeesDetails(@AuthenticationPrincipal User user, Model model) {
//		List<EmployeeDetails> listOfEmployeeDetails = employeeDetailsService.getEmployeeDetails();
//		model.addAttribute("listOfEmployeeDetails", listOfEmployeeDetails);
//		return "dashboard";
//	}
//
//	@ResponseBody
//	@RequestMapping(value = "/api/employee_biodata/employeeDetails/oneEmployeeDetails", method = RequestMethod.GET)
//	public Optional<EmployeeDetails> getEmployeeDetailsById(Long id, Model model) {
//		return employeeDetailsService.getEmployeeDetailsById(id);
//	}
//
//	@RequestMapping(value = "/api/employee_biodata/employeeDetails/addEmployeeeDetails", method = RequestMethod.POST)
//	public String addEmployeeDetails(EmployeeDetails employeeDetails) {
//		employeeDetailsService.addEmployeDetails(employeeDetails);
//		return "redirect:/dashboard";
//	}
//
//	@RequestMapping(value = "/api/employee_biodata/employeeDetails/editEmployeeDetails", method = { RequestMethod.GET,
//			RequestMethod.PUT, RequestMethod.POST })
//	public String updateEmployeeeDetails(EmployeeDetails employeeDetails) {
//		employeeDetailsService.updateEmployeeDetails(employeeDetails);
//		return "redirect:/dashboard";
//	}
//
//	@RequestMapping(value = "/api/employee_biodata/employeeDetails/deleteEmployeeDetails", method = { RequestMethod.GET,
//			RequestMethod.DELETE })
//	public String removeEmployeeDetails(@PathVariable Long id) {
//		employeeDetailsService.removeEmployeeDetails(id);
//		return "redirect:/dashboard";
//	}
}