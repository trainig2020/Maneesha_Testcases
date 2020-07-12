package com.model.dao;



import java.util.List;

import com.model.persistance.Employee;
import com.model.service.EmployeeService;

public interface EmployeeDao {

	public void createEmployee() throws Exception;

	public boolean insertEmployee(Employee emp);

	public boolean updateEmployee(Employee emp);

	public boolean deleteEmployee(int deptId);

	public List<EmployeeService> getAllEmployees(int deptId);

}
