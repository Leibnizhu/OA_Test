package leibniz.hu.oatest.action;

import java.io.File;
import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import leibniz.hu.oatest.domain.Form;
import leibniz.hu.oatest.domain.FormTemplate;
import leibniz.hu.oatest.domain.TaskView;
import leibniz.hu.oatest.service.FormService;
import leibniz.hu.oatest.service.FormTemplateService;

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
		this.formServ.submit(this.ftid, this.resource);
		//提交后返回到模板列表
		return jumpAction;
	}
	
	//
	public String showCurTasks(){
		Collection<TaskView> tvList = this.formServ.getAllFormByAssign();
		ActionContext.getContext().put("tvList", tvList);
		return "curTasksList";
	}
}
