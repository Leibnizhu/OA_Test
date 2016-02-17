package leibniz.hu.oatest.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import leibniz.hu.oatest.dao.GenericDao;
import leibniz.hu.oatest.domain.Department;
import leibniz.hu.oatest.service.DepartmentService;

@Service("departmentService")
public class DepartmentServiceImpl extends GenericServiceImpl<Department>implements DepartmentService{
	@Resource(name="departmentDao")
	public void initDao(GenericDao<Department> dao) {
		//用于给父类GenericServiceImpl的dao注入赋值
        super.setDao(dao);
    }
}