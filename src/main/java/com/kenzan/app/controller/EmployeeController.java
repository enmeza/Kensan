package com.kenzan.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kenzan.app.model.DataResponse;
import com.kenzan.app.model.Employee;
import com.kenzan.app.model.EmployeeListResponse;
import com.kenzan.app.model.EmployeeResponse;
import com.kenzan.app.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody DataResponse saveEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.POST)
	public @ResponseBody EmployeeListResponse getAll(){
		return employeeService.getAll();
	}
	
	@RequestMapping(value = "/getById", method = RequestMethod.POST)
	public @ResponseBody EmployeeResponse getEmployeeById(@RequestParam(value = "id") Integer id) {
		return employeeService.getEmployeeById(id);
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public @ResponseBody DataResponse modifyEmployee(@RequestBody Employee employee) {
		return employeeService.modifyEmployee(employee);
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public @ResponseBody DataResponse deleteEmployeeById(@RequestParam(value = "id") Integer id) {
		return employeeService.deleteEmployeeById(id);
	}
	
	@RequestMapping(value = "/authentication", method = RequestMethod.POST)
	public @ResponseBody DataResponse authentication(@RequestParam(value = "user") String user, @RequestParam(value = "pass") String pass) {
		return employeeService.authentication(user, pass);
	}
}
