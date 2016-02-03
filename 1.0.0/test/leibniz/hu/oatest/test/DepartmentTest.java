package leibniz.hu.oatest.test;

import java.util.Collection;

import leibniz.hu.oatest.domain.Department;
import leibniz.hu.oatest.service.DepartmentService;

import org.junit.Test;

public class DepartmentTest extends SpringUtil{
	@Test
	public void DepartmentSaveTest(){
		DepartmentService ds = (DepartmentService) ctx.getBean("departmentService");
		Department department = new Department();
		department.setDname("研发部");
		department.setDdescript("全是男的");
		ds.saveDepartment(department);
	}
	
	@Test
	public void DepartmentListTest(){
		DepartmentService ds = (DepartmentService) ctx.getBean("departmentService");
		Collection<Department> cd = ds.getAllDepartments();
		System.out.println(cd.size());
	}
}
