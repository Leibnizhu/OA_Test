package leibniz.hu.oatest.action;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import leibniz.hu.oatest.domain.Job;
import leibniz.hu.oatest.service.JobService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

@Controller("jobAction")
public class JobAction extends ActionUtil<Job> implements ModelDriven<Job>{
	private static final long serialVersionUID = 2375265383702304071L;
	
	@Resource(name="jobService")
	private JobService jobService;
	
	//列出所有岗位
	public String listAll(){
		Collection<Job> jobList = this.jobService.getAllElements();
		ActionContext.getContext().put("jobList", jobList);
		return list;
	}
	
	//显示增加岗位页面
	public String addWeb(){
		ActionContext.getContext().getValueStack().pop();
		return addWeb;
	}
	
	//实际增加岗位的后台操作
	public String add(){
		this.jobService.saveElement(this.getModel());
		return jumpAction;
	}
	
	//删除岗位
	public String delete(){
		Job job = this.jobService.getElementById(this.getModel().getJid());
		if(null != job){
			this.jobService.deleteElement(job);
		}
		return jumpAction;
	}
	
	//修改岗位的页面
	public String updateWeb(){
		Job job = this.jobService.getElementById(this.getModel().getJid());
		ActionContext.getContext().getValueStack().push(job);
		return updateWeb;
	}
	
	//修改岗位的后台操作
	public String update(){
		this.jobService.updateElement(this.getModel());
		return jumpAction;
	}
}
