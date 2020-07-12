package com.model.mainTest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.model.persistance.Department;
import com.model.service.DepartmentServiceImpl;
import com.model.service.DepartmentService;

public class DepartmentDaoTest {
	Department d = new Department();

	@Test
	public void testCreateDepartment() {

		d.setDeptId(7);
		d.setDeptName("ECHO");
		assertEquals("Department Details Added Successfully",
				DepartmentServiceImpl.insertDepartment(dept));
	}

	@Test
	public void testUpdateDepartment() {
		assertEquals("Department Updated successfully",
				DepartmentServiceImpl.updateDepartment("MECH", 6));
	}

	@Test
	public void testDeleteDepartment() {
		assertEquals("Department details deleted successfully",
				DepartmentServiceImpl.deleteDepartment(5));
	}

	@Test
	public void testGetAllDepartments() {
		List<Department> lst = DepartmentServiceImpl.getAllDepartments();
		for (Department dep : lst) {
			System.out.println(dep.getDeptId());
			System.out.println(dep.getDeptName());
		}
		assertNotNull(lst);
	}

}
