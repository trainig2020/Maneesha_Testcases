package com.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.persistance.Employee;
import com.model.service.EmployeeService;

public class EmployeeDaoImpl implements EmployeeDao {
	Connection con = connectionFactory.getConnection();

	@Override
	public void createEmployee() throws Exception {

		String sql = "create table employee(eId int(10) not null primary key,eName varchar(20) not null,eSalary int(10) not null,"
				+ "deptId int(10) not null ,foreign key(deptId) references department(deptId))";

		Statement stmt = con.createStatement();

		stmt.execute(sql);

		System.out.println("Table created");
		stmt.close();

	}

	@Override
	public boolean insertEmployee(Employee emp) {

		try {
			PreparedStatement ps = con
					.prepareStatement("INSERT INTO employee VALUES ( ?, ?,?,?)");
			ps.setInt(1, emp.geteId());
			ps.setString(2, emp.geteName());
			ps.setInt(3, emp.geteSalary());
			ps.setInt(4, emp.getDeptId());
			int i = ps.executeUpdate();
			if (i == 1) {
				return true;
			}
			ps.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateEmployee(Employee emp) {
		try {
			PreparedStatement ps = con
					.prepareStatement("UPDATE employee SET eName=?,eSalary=?,deptId=? WHERE eId=?");
			ps.setString(1, emp.geteName());
			ps.setInt(2, emp.geteSalary());
			ps.setInt(3, emp.getDeptId());
			ps.setInt(4, emp.geteId());
			int i = ps.executeUpdate();
			if (i == 1) {
				return true;
			}
			ps.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	public boolean deleteEmployee(int deptId) {

		try {
			Statement stmt = con.createStatement();
			int i = stmt.executeUpdate("DELETE FROM employee WHERE deptId="
					+ deptId);
			if (i >= 1) {
				return true;
			}
			stmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public List<EmployeeService> getAllEmployees(int deptId) {

		String query = "SELECT * FROM employee where deptId=?";

		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, deptId);
			ResultSet rs = stmt.executeQuery();
			List<EmployeeService> emp = new ArrayList<EmployeeService>();
			while (rs.next()) {
				System.out.println("eId :" + rs.getInt(1) + " eName :"
						+ rs.getString(2) + " eSalary :" + rs.getInt(3)
						+ " deptId: " + rs.getInt(4));

			}
			stmt.close();
			return emp;

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;

	}

}
