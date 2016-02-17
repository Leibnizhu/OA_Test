package leibniz.hu.oatest.dao.impl;

import org.springframework.stereotype.Repository;

import leibniz.hu.oatest.dao.DepartmentDao;
import leibniz.hu.oatest.domain.Department;

@Repository("departmentDao")
public class DepartmentDaoImpl extends GenericDaoImpl<Department> implements DepartmentDao{

	
}
