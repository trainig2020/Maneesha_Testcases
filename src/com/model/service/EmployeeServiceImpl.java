package com.model.service;

import java.util.List;

import com.model.dao.EmployeeDao;
import com.model.dao.EmployeeDaoImpl;
import com.model.persistance.Employee;

public class EmployeeServiceImpl implements EmployeeService {

	EmployeeDao dao = new EmployeeDaoImpl();

	public void createEmployee() throws Exception {
		
		dao.createEmployee();

	}

	public boolean insertEmployee(Employee emp) {
		
		return dao.insertEmployee(emp);
	}

	public boolean updateEmployee(Employee emp) {
		
		return dao.updateEmployee(emp);
	}

	public boolean deleteEmployee(int deptId) {
		
		return dao.deleteEmployee(deptId);
	}

	public List<EmployeeService> getAllEmployees(int deptId) {

		return dao.getAllEmployees(deptId);
	}

}
