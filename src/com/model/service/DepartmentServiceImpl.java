package com.model.service;
import java.util.List;
import com.model.dao.DepartmentDao;
import com.model.dao.DepartmentDaoImpl;
import com.model.persistance.Department;

public class DepartmentServiceImpl implements DepartmentService {

	DepartmentDao dao = new DepartmentDaoImpl();

	@Override
	public void createDepartment() throws Exception {

		dao.createDepartment();
	}

	@Override
	public boolean insertDepartment(Department dept) {
		return dao.insertDepartment(dept);
	}

	@Override
	public List<Department> getAllDepartments(Department dept) {
		
		return dao.getAllDepartments(dept);
	}

	@Override
	public boolean updateDepartment(Department dept) {
		return dao.updateDepartment(dept);
	}

	@Override
	public boolean deleteDepartment(int deptId) {
		return dao.deleteDepartment(deptId);
	}

}
