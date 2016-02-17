package leibniz.hu.oatest.action;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import leibniz.hu.oatest.domain.Department;
import leibniz.hu.oatest.service.DepartmentService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

@Controller("departmentAction")
@Scope("prototype")
public class DepartmentAction extends ActionUtil<Department> implements ModelDriven<Department>{
	private static final long serialVersionUID = 7456261795822642198L;
	
	//Service
	@Resource(name="departmentService")
	private DepartmentService deptServ;
	public DepartmentService getDeptServ() {
		return deptServ;
	}
	public void setDeptServ(DepartmentService deptServ) {
		this.deptServ = deptServ;
	}
	
	//显示所有部门
	public String listAll(){
//		Collection<Department> deptList = this.deptServ.getAllDepartments();
		Collection<Department> deptList = this.deptServ.getAllElements();
		ActionContext.getContext().put("deptList", deptList);
		return list;
	}
	
	//删除指定部门
	public String delete(){
		Department dept = this.deptServ.getElementById(this.getModel().getDid());
		this.deptServ.deleteElement(dept);
		return jumpAction;
	}
	
	//打开增加部门的页面
	public String addWeb(){
		ActionContext.getContext().getValueStack().pop();
		return addWeb;
	}
	
	//增加部门的实际操作
	public String add(){
		this.deptServ.saveElement(this.getModel());
		return jumpAction;
	}
	
	//打开修改部门的页面
	public String updateWeb(){
		Department dept = this.deptServ.getElementById(this.getModel().getDid());
		ActionContext.getContext().getValueStack().push(dept);
		return updateWeb;
	}
	
	//修改部门的实际业务操作
	public String update(){
		this.deptServ.updateElement(this.getModel());
		return jumpAction;
	}
}
