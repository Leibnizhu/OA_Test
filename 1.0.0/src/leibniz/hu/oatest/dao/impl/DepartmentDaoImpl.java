package leibniz.hu.oatest.dao.impl;

import java.io.Serializable;
import java.util.Collection;

import leibniz.hu.oatest.dao.DepartmentDao;
import leibniz.hu.oatest.domain.Department;

public class DepartmentDaoImpl extends GenericDaoImpl<Department> implements DepartmentDao{

	@Override
	public void saveDepartment(Department department) {
		this.getHibernateTemplate().save(department);
	}

	@Override
	public void deleteDepartment(Department department) {
		this.getHibernateTemplate().delete(department);
	}

	@Override
	public void updateDepartment(Department department) {
		this.getHibernateTemplate().update(department);
	}

	@Override
	public Department getDepartmentById(Serializable id) {
		return (Department) this.getHibernateTemplate().get(Department.class,id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Department> getAllDepartments() {
		return this.getHibernateTemplate().find(" from Department");
	}
	
}
