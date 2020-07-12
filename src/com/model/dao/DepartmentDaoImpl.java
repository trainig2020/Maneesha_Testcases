package com.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.persistance.Department;

public class DepartmentDaoImpl implements DepartmentDao {

	Connection con = connectionFactory.getConnection();

	@Override
	public void createDepartment() throws Exception {

		String sql = "create table department(deptId int(10) not null primary key,deptName varchar(20) not null)";

		Statement stmt = con.createStatement();

		stmt.execute(sql);

		System.out.println("Table created");
		stmt.close();

	}

	@Override
	public boolean insertDepartment(Department dept) {

		try {
			PreparedStatement ps = con
					.prepareStatement("INSERT INTO department VALUES ( ?, ?)");
			ps.setInt(1, dept.getDeptId());
			ps.setString(2, dept.getDeptName());
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
	public List<Department> getAllDepartments(Department dept) {

		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM department");
			ArrayList<Department> department = new ArrayList<Department>();
			while (rs.next()) {
				System.out.println("DeptId :" + rs.getInt(1) + " DeptName :"
						+ rs.getString(2));
			}
			stmt.close();
			return department;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateDepartment(Department dept) {
		try {
			PreparedStatement ps = con
					.prepareStatement("UPDATE department SET deptName=? WHERE deptId=?");
			ps.setString(1, dept.getDeptName());
			ps.setInt(2, dept.getDeptId());
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

	public boolean deleteDepartment(int deptId) {

		try {
			Statement stmt = con.createStatement();
			int i = stmt.executeUpdate("DELETE FROM department WHERE deptId="
					+ deptId);
			if (i == 1) {
				return true;
			}
			stmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;

	}

}
