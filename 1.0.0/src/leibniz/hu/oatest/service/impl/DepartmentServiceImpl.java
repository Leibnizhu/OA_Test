package leibniz.hu.oatest.service.impl;

import java.io.Serializable;
import java.util.Collection;

import leibniz.hu.oatest.dao.DepartmentDao;
import leibniz.hu.oatest.domain.Department;
import leibniz.hu.oatest.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService{
	private DepartmentDao departmentDao;
	public DepartmentDao getDepartmentDao() {
		return departmentDao;
	}

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	@Override
	public void saveDepartment(Department department) {
		this.departmentDao.saveDepartment(department);
	}

	@Override
	public void deleteDepartmentById(Serializable id) {
		this.departmentDao.deleteDepartment(getDepartmentById(id));
	}

	@Override
	public void updateDepartment(Department ddepartment) {
		this.departmentDao.updateDepartment(ddepartment);
	}

	@Override
	public Department getDepartmentById(Serializable id) {
		return this.departmentDao.getDepartmentById(id);
	}

	@Override
	public Collection<Department> getAllDepartments() {
		return this.departmentDao.getAllDepartments();
	}

}
