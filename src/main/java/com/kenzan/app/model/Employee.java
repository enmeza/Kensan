package com.kenzan.app.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class Employee implements Serializable {
	
	private static final long serialVersionUID = -7627625982744202255L;
	
	private Integer id;
	
	@NotNull
	private String firstName;
	
	private String middleName;
	
	@NotNull
	private String lastName;
	
	@NotNull
	private String dateOfBirth;
	
	@NotNull
	private String dateOfEmployment;
	
	private Integer status;
	
	public Employee setId(Integer id) {
		this.id = id;
		return this;
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public Employee setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public Employee setMiddleName(String middleName) {
		this.middleName = middleName;
		return this;
	}
	
	public String getMiddleName() {
		return this.middleName;
	}
	
	public Employee setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public Employee setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
		return this;
	}
	
	public String getDateOfBirth() {
		return this.dateOfBirth;
	}
	
	public Employee setDateOfEmployment(String dateOfEmployment) {
		this.dateOfEmployment = dateOfEmployment;
		return this;
	}
	
	public String getDateOfEmployment() {
		return this.dateOfEmployment;
	}
	
	public Employee setStatus(Integer status) {
		this.status = status;
		return this;
	}
	
	public Integer getStatus() {
		return this.status;
	}

}
