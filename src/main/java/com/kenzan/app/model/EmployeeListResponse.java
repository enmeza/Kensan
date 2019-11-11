package com.kenzan.app.model;

import java.util.List;

public class EmployeeListResponse extends DataResponse{

	private static final long serialVersionUID = 616053778206057090L;
	
	private List<Employee> employeeList;

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public EmployeeListResponse setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
		return this;
	}
}
