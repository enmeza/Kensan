package com.kenzan.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kenzan.app.model.DataResponse;
import com.kenzan.app.model.Employee;
import com.kenzan.app.model.EmployeeListResponse;
import com.kenzan.app.model.EmployeeResponse;
import com.kenzan.app.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public DataResponse saveEmployee(Employee employee) {
		return employeeRepository.saveEmployee(employee);
	}
	
	public EmployeeListResponse getAll(){
		return employeeRepository.getAll();
	}
	
	public EmployeeResponse getEmployeeById(Integer id) {
		return employeeRepository.getEmployeeById(id);
	}
	
	public DataResponse modifyEmployee(Employee employee) {
		return employeeRepository.modifyEmployee(employee);
	}
	
	public DataResponse deleteEmployeeById(Integer id) {
		return employeeRepository.deleteEmployeeById(id);
	}
	
	public DataResponse authentication(String user, String pass) {
		DataResponse response = new DataResponse().setSuccess(Boolean.FALSE).setMessage("The user and/or password are not correct");
		if (user.equalsIgnoreCase("admin") && pass.equalsIgnoreCase("123")) {
			response.setSuccess(Boolean.TRUE).setMessage("Valid");
		}
		return response;
	}
}
