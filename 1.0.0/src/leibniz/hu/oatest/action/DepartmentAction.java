package leibniz.hu.oatest.action;

import java.util.Collection;

import leibniz.hu.oatest.domain.Department;
import leibniz.hu.oatest.service.DepartmentService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

public class DepartmentAction extends ActionUtil implements ModelDriven<Department>{
	private static final long serialVersionUID = 7456261795822642198L;
	//模型驱动
	private Department model = new Department();
	public void setModel(Department model) {
		this.model = model;
	}
	@Override
	public Department getModel() {
		return model;
	}
	
	//Service
	private DepartmentService deptServ;
	public DepartmentService getDeptServ() {
		return deptServ;
	}
	public void setDeptServ(DepartmentService deptServ) {
		this.deptServ = deptServ;
	}
	
	//显示所有部门
	public String listAll(){
		Collection<Department> deptList = this.deptServ.getAllDepartments();
		ActionContext.getContext().put("deptList", deptList);
		return list;
	}
	
	//删除指定部门
	public String delete(){
		this.deptServ.deleteDepartmentById(this.getModel().getDid());
		return jumpAction;
	}
	
	//打开增加部门的页面
	public String addWeb(){
		return addWeb;
	}
}
