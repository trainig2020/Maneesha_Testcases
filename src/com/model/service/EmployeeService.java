package com.model.service;



import java.util.List;

import com.model.persistance.Employee;

public interface EmployeeService {

	public void createEmployee() throws Exception;

	public boolean insertEmployee(Employee emp);

	public boolean updateEmployee(Employee emp1);

	public boolean deleteEmployee(int deptId);

	public List<EmployeeService> getAllEmployees(int deptId);

}
