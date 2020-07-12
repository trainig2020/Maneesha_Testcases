package com.model.mainTest;

/*import static org.junit.Assert.*;

import org.junit.Test;

public class EmployeeDaoTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
*/

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.model.persistance.Department;
import com.model.persistance.Employee;
import com.model.service.DepartmentServiceImpl;
import com.model.service.EmployeeServiceImpl;

public class EmployeeDaoTest {
    Employee e = new Employee();
	@Test
	public void testCreateEmployee() {
		e.seteId(410);
		e.seteName("kavitha");
		e.setDeptId(8);
		assertEquals("Employee Added Successfully", EmployeeServiceImpl.importEmployee(e));
	}

	@Test
	public void testUpdateEmployee() {
		assertEquals("Employee details updated", EmployeeServiceImpl.updateEmployee(3, 403, "Anugna"));
	}

	@Test
	public void testDeleteEmployee() {
		assertEquals("Employee details deleted Successfully", EmployeeServiceImpl.deleteEmployee(8, 401));
	}

	@Test
	public void testGetAllEmployees() {
		e.setDeptId(8);
		List<Employee> lst = EmployeeServiceImpl.getAllEmployees();
		for (Employee employee : lst) {
			System.out.println(employee.geteId());
			System.out.println(employee.geteName());
			System.out.println(employee.getDeptId());
		}
		assertNotNull(lst);
	}
}