package com.kenzan.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmployeeWebController {
	
	@RequestMapping(value="/employee", method=RequestMethod.GET)
	public String showEmployeePage() {
		return "employee";
	}
	
	@RequestMapping(value="/employeeTable", method=RequestMethod.GET)
	public String showEmployeeTablePage() {
		return "employeeTable";
	}
	
	@RequestMapping(value="/createEmployee", method=RequestMethod.GET)
	public String showCreateEmployeePage() {
		return "createEmployee";
	}
	
	@RequestMapping(value="/findEmployee", method=RequestMethod.GET)
	public String showFindEmployee() {
		return "findEmployee";
	}
}
