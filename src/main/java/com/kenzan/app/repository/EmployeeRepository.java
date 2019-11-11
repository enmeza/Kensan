package com.kenzan.app.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.kenzan.app.model.DataResponse;
import com.kenzan.app.model.Employee;
import com.kenzan.app.model.EmployeeListResponse;
import com.kenzan.app.model.EmployeeResponse;
import com.kenzan.configuration.SQLConnection;

@Repository
public class EmployeeRepository {

	public DataResponse saveEmployee(Employee employee) {
		Connection conn = SQLConnection.getConnection();
		String sql = "INSERT INTO employee (first_name, middle_initial, last_name, date_of_birth, date_of_employment, status) VALUES (?,?,?,?,?,?);";
		PreparedStatement ps = null;
		DataResponse dateResponse = new DataResponse();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, employee.getFirstName());
			ps.setString(2, employee.getMiddleName());
			ps.setString(3, employee.getLastName());
			ps.setString(4, employee.getDateOfBirth());
			ps.setString(5, employee.getDateOfEmployment());
			ps.setInt(6, 1);
			ps.execute();
			dateResponse.setSuccess(Boolean.TRUE).setMessage("The employee " + employee.getFirstName() + " was saved.");
		} catch (SQLException e) {
			dateResponse.setSuccess(Boolean.FALSE).setMessage(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dateResponse;
	}
	
	public EmployeeListResponse getAll(){
		Connection conn = SQLConnection.getConnection();
		List<Employee> employeeList = new ArrayList<>();
		String sql = "SELECT * FROM employee;";
		Statement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				employeeList.add(employeeMapping(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return new EmployeeListResponse().setEmployeeList(employeeList);
	}
	
	public EmployeeResponse getEmployeeById(Integer id) {
		Connection conn = SQLConnection.getConnection();
		EmployeeResponse response = new EmployeeResponse();
		String sql = "SELECT * FROM employee WHERE id = ?;";
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			response.setSuccess(Boolean.TRUE);
			
			if (rs.next() == true) {
				response.setEmployee(employeeMapping(rs)).setMessage("Success");
			} else {
				response.setMessage("No record was found");
			}
		} catch (SQLException e) {
			response.setSuccess(Boolean.FALSE);
			response.setMessage(e.getMessage());
			e.printStackTrace();
		}
		
		return response;
	}
	
	public DataResponse modifyEmployee(Employee employee) {
		Connection conn = SQLConnection.getConnection();
		String sql = "UPDATE employee SET first_name = ?, middle_initial = ?, last_name = ?, date_of_birth = ?, date_of_employment = ? WHERE id = ?;";
		PreparedStatement ps = null;
		DataResponse dateResponse = new DataResponse();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, employee.getFirstName());
			ps.setString(2, employee.getMiddleName());
			ps.setString(3, employee.getLastName());
			ps.setString(4, employee.getDateOfBirth());
			ps.setString(5, employee.getDateOfEmployment());
			ps.setInt(6, employee.getId());
			ps.executeUpdate();
			dateResponse.setSuccess(Boolean.TRUE).setMessage("The employee " + employee.getFirstName() + " was updated.");
		} catch (SQLException e) {
			dateResponse.setSuccess(Boolean.FALSE).setMessage(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dateResponse;
	}
	
	public DataResponse deleteEmployeeById(Integer id) {
		Connection conn = SQLConnection.getConnection();
		DataResponse response = new DataResponse();
		String sql = "UPDATE employee SET status = 0 WHERE id = ?;";
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			int affectedRows = ps.executeUpdate();
			
			if (affectedRows > 0) {
				response.setSuccess(Boolean.TRUE).setMessage("The employee has been disabled");
			} else {
				response.setSuccess(Boolean.FALSE).setMessage("The employee was not found");
			}
		} catch (SQLException e) {
			response.setSuccess(Boolean.FALSE);
			response.setMessage(e.getMessage());
			e.printStackTrace();
		}
		
		return response;
	}
	
	private Employee employeeMapping(ResultSet rs) throws SQLException {
		return new Employee().setId(rs.getInt("id"))
			.setFirstName(rs.getString("first_name"))
			.setMiddleName(rs.getString("middle_initial"))
			.setLastName(rs.getString("last_name"))
			.setDateOfBirth(rs.getString("date_of_birth"))
			.setDateOfEmployment(rs.getString("date_of_employment"))
			.setStatus(rs.getInt("status"));
	}
}
