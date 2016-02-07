package leibniz.hu.oatest.service;

import java.io.Serializable;
import java.util.Collection;

import leibniz.hu.oatest.domain.Department;

public interface DepartmentService extends GenericService<Department>{
	//增
		public void saveDepartment(Department department);
		//删
		public void deleteDepartmentById(Serializable id);
		//改
		public void updateDepartment(Department ddepartment);
		//查
		public Department getDepartmentById(Serializable id);
		
		public Collection<Department> getAllDepartments();
}
