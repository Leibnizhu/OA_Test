package leibniz.hu.oatest.dao;

import java.io.Serializable;
import java.util.Collection;

import leibniz.hu.oatest.domain.Department;

public interface DepartmentDao {
	//增
	public void saveDepartment(Department department);
	//删
	public void deleteDepartment(Department department);
	//改
	public void updateDepartment(Department ddepartment);
	//查
	public Department getDepartmentById(Serializable id);
	
	public Collection<Department> getAllDepartments();
}
