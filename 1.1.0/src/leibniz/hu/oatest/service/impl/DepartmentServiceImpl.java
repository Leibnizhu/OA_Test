package leibniz.hu.oatest.service.impl;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import leibniz.hu.oatest.dao.DepartmentDao;
import leibniz.hu.oatest.domain.Department;
import leibniz.hu.oatest.service.DepartmentService;

@Service("departmentService")
public class DepartmentServiceImpl extends GenericServiceImpl<Department>implements DepartmentService{
	@Resource(name="departmentDao")
	private DepartmentDao departmentDao;
	public DepartmentDao getDepartmentDao() {
		return departmentDao;
	}

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	@Override
	public void saveDepartment(Department department) {
		this.departmentDao.saveElement(department);
	}

	@Override
	public void deleteDepartmentById(Serializable id) {
		this.departmentDao.deleteElement(getDepartmentById(id));
	}

	@Override
	public void updateDepartment(Department department) {
		this.departmentDao.updateElement(department);
	}

	@Override
	public Department getDepartmentById(Serializable id) {
		return this.departmentDao.getElementById(id);
	}

	@Override
	public Collection<Department> getAllDepartments() {
		return this.departmentDao.getAllElements();
	}
}