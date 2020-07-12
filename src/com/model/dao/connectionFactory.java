package com.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectionFactory {

	public static Connection getConnection() {
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			return DriverManager
					.getConnection("jdbc:mysql://localhost:3306/employee_details",
							"root", "root");
		} catch (SQLException ex) {
			throw new RuntimeException("No Database connection found", ex);
		}
	}
}