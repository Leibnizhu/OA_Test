package leibniz.hu.oatest.action;

import java.util.Collection;
import java.util.Set;

import javax.annotation.Resource;

import leibniz.hu.oatest.domain.Department;
import leibniz.hu.oatest.domain.Job;
import leibniz.hu.oatest.domain.User;
import leibniz.hu.oatest.service.DepartmentService;
import leibniz.hu.oatest.service.JobService;
import leibniz.hu.oatest.service.UserService;
import leibniz.hu.oatest.utils.OaUtils;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

@Controller("userAction")
@Scope("prototype")
public class UserAction extends ActionUtil<User>implements ModelDriven<User>{
	private static final long serialVersionUID = 9213851736233247844L;
	
	//用于查询的Service层
	@Resource(name="userService")
	private UserService userServ;
	
	@Resource(name="departmentService")
	private DepartmentService deptServ;
	
	@Resource(name="jobService")
	private JobService jobServ;
	
	//页面上的其他属性，属性驱动
	private Long did;
	private Long[] jids;
	
	public Long getDid(){
		return this.did;
	}
	public void setDid(Long did){
		this.did = did;
	}
	public Long[] getJids(){
		return this.jids;
	}
	public void setJids(Long[] jids){
		this.jids = jids;
	}
	
	//列出所有用户及对应的部门、岗位信息
	public String listAll(){
		Collection<User> userList = this.userServ.getAllUsers();
		ActionContext.getContext().getValueStack().push(userList);;
		return list;
	}
	
	//删除指定用户
	public String delete(){
		//从模型驱动获取User一般属性，从而查询到User对象
		User user = this.userServ.getElementById(this.getModel().getUid());
		//在数据库中删除
		this.userServ.deleteElement(user);
		return jumpAction;
	}
	
	//显示增加用户的页面
	//页面需要提供可选的部门和岗位，所以要查询这两个表的信息
	public String addWeb(){
		Collection<Department> deptList = this.deptServ.getAllElements();
		ActionContext.getContext().put("deptList", deptList);
		Collection<Job> jobList = this.jobServ.getAllElements();
		ActionContext.getContext().put("jobList", jobList);
		return addWeb;
	}
	
	//增加用户的后台操作，需要同步操作部门和岗位的表
	//页面中的数据来源于多张表，只靠模型驱动还不够，还需要属性驱动
	public String add(){
		//从模型驱动获取User一般属性
		User user = this.getModel();
		//从属性驱动获取其他属性的id，并通过其他表的service层获取相应对象并设定到User对应属性
		Department dept = this.deptServ.getElementById(this.did);
		Set<Job> jobs = this.jobServ.getJobsByIds(this.jids);
		user.setDepartment(dept);
		user.setJobs(jobs);
		//保存到数据库
		this.userServ.saveElement(user);
		return jumpAction;
	}
	
	//更新用户的jsp页面显示
	//需要准备用户的基本属性以及外表的属性（部门和岗位的回显默认值）
	//以及所有的岗位和部门信息，以供jsp页面的候选项显示
	public String updateWeb(){
		//准备用户的基本属性，放入值栈
		User user = this.userServ.getElementById(this.getModel().getUid());
		ActionContext.getContext().getValueStack().push(user);
		//准备页面的岗位和部门回显id
		this.did = user.getDepartment().getDid();
		Set<Job> jobs = user.getJobs();
		this.jids = new Long[jobs.size()];
		int i = 0;
		for(Job job : jobs){
			this.jids[i++] = job.getJid();
		}
		//准备所有的岗位和部门信息放入对象栈
		Collection<Department> deptList = this.deptServ.getAllElements();
		Collection<Job> jobList = this.jobServ.getAllElements();
		ActionContext.getContext().put("deptList", deptList);
		ActionContext.getContext().put("jobList", jobList);
		return updateWeb;
	}
	
	//更新用户信息的后台操作
	//需要同步更新外键
	public String update(){
		//从模型驱动获取User一般属性
		User user = this.getModel();
		//从属性驱动获取其他属性的id，并通过其他表的service层获取相应对象并设定到User对应属性
		Department dept = this.deptServ.getElementById(this.did);
		Set<Job> jobs = this.jobServ.getJobsByIds(this.jids);
		user.setDepartment(dept);
		user.setJobs(jobs);
		//更新到数据库
		this.userServ.updateElement(user);
		return jumpAction;
	}
	
	public String login(){
		//根据当前页面传回的用户名和密码查询
		User user = this.userServ.getUserByNameNPswd(this.getModel().getUsername(), this.getModel().getPassword());
		if(null == user){
			//如果查询不到，则继续返回登陆页面
			ServletActionContext.getRequest().getSession().setAttribute("errorMsg", "用户名或密码错误，请重新输入。");
			return "login";
		} else {
			//查询到，将user对象放进session并转到主页面
			OaUtils.putUserToSession(user);
			return "index";
		}
	}
	
	public String logout(){
		ServletActionContext.getRequest().getSession().removeAttribute("errorMsg");
		ServletActionContext.getRequest().getSession().removeAttribute("user");
		return "login";
	}
}
