package leibniz.hu.oatest.action;

import java.io.File;
import java.util.Collection;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import leibniz.hu.oatest.domain.Approval;
import leibniz.hu.oatest.domain.Form;
import leibniz.hu.oatest.domain.FormTemplate;
import leibniz.hu.oatest.domain.TaskView;
import leibniz.hu.oatest.domain.User;
import leibniz.hu.oatest.service.FormService;
import leibniz.hu.oatest.service.FormTemplateService;
import leibniz.hu.oatest.utils.OaUtils;

@Controller("formAction")
@Scope("prototype")
public class FormAction extends ActionUtil<Form>{
	private static final long serialVersionUID = 4181857742970260605L;

	@Resource(name="formService")
	private FormService formServ;
	
	@Resource(name="formTemplateService")
	private FormTemplateService ftServ;
	
	//用于上传表单
	private File resource;
	//用于提交申请时，传递所使用的表单模板的id
	private Long ftid;
	//跳转至审批页面时，传递taskid
	private String taskId;
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	//用于审批时，提交意见
	private String comment;
	//用于审批时，提交评审结论
	private String isAgree;
	
	//getter & setter
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getIsAgree() {
		return isAgree;
	}
	public void setIsAgree(String isAgree) {
		this.isAgree = isAgree;
	}
	public Long getFtid() {
		return ftid;
	}
	public void setFtid(Long ftid) {
		this.ftid = ftid;
	}
	public File getResource() {
		return resource;
	}
	public void setResource(File resource) {
		this.resource = resource;
	}

	//以下为Action
	public String listAllFormTemplate(){
		Collection<FormTemplate> ftList = this.ftServ.getAllElements();
		ActionContext.getContext().put("ftList", ftList);
		return "ft_list";
	}
	
	//跳转
	public String submitWeb(){
		return "submitWeb";
	}
	
	//提交申请
	public String submit(){
		if(null != this.resource){
			this.formServ.submit(this.ftid, this.resource);
		}
		//提交后返回到模板列表
		return jumpAction;
	}
	
	//显示当前用户所有的代办任务
	public String showCurTasks(){
		Collection<TaskView> tvList = this.formServ.getAllFormByAssign();
		ActionContext.getContext().put("tvList", tvList);
		return "curTasksList";
	}
	
	//跳转到审批任务的页面
	public String approveWeb(){
		return "approveWeb";
	}
	
	//审批
	public String approve(){
		//获得组装approval所需的材料
		User user = OaUtils.getUserFromSession();
		Form form = this.formServ.getElementById(this.getModel().getFid());
		//拼装Approval对象
		Approval approval = new Approval();
		approval.setApprover(user.getUsername());
		approval.setApproveTime(new Date());
		approval.setComment(this.comment);
		approval.setForm(form);
		approval.setIsAgree(this.isAgree);
		//调用service完成审批处理
		this.formServ.approve(this.taskId, approval);
		return "jumpTaskList";
	}
}
