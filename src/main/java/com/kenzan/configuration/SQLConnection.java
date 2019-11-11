package com.kenzan.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLConnection {

	private static Connection conn = null;
	
	private SQLConnection() {}
	
	public static Connection getConnection() {
		if (conn == null) {
			StringBuilder url = new StringBuilder("jdbc:sqlite:");
			url.append(System.getProperty("user.dir")).append(System.getProperty("file.separator"))
				.append("src").append(System.getProperty("file.separator"))
				.append("main").append(System.getProperty("file.separator"))
				.append("resources").append(System.getProperty("file.separator"))
				.append("kenzan.db");
			try {
				conn = DriverManager.getConnection(url.toString());
				createTableIfNotExist();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return conn;
	}
	
	private static void createTableIfNotExist() {
		StringBuilder employeeTables = new StringBuilder();
		employeeTables.append("CREATE TABLE IF NOT EXISTS employee (")
			.append("id integer primary key,")
			.append("first_name varchar(30),")
			.append("middle_initial varchar(30),")
			.append("last_name varchar(30),")
			.append("date_of_birth text,")
			.append("date_of_employment text,")
			.append("status int)");
		Connection conn = SQLConnection.getConnection();
		try {
			Statement st = conn.createStatement();
			st.execute(employeeTables.toString());
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void closeConnection() {
		try {
			conn.close();
			conn = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
