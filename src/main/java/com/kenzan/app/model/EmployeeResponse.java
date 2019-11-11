package com.kenzan.app.model;

public class EmployeeResponse extends DataResponse {

	private static final long serialVersionUID = -5673389885235782297L;
	private Employee employee;

	public Employee getEmployee() {
		return employee;
	}

	public EmployeeResponse setEmployee(Employee employee) {
		this.employee = employee;
		return this;
	}
}
