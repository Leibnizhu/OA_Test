package leibniz.hu.oatest.action;

import java.io.File;
import java.util.Collection;

import javax.annotation.Resource;

import leibniz.hu.oatest.domain.FormTemplate;
import leibniz.hu.oatest.service.FormTemplateService;
import leibniz.hu.oatest.service.ProcDefManager;
import leibniz.hu.oatest.utils.UploadUtils;

import org.jbpm.api.ProcessDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

@Controller("formTemplateAction")
@Scope("prototype")
public class FormTemplateAction extends ActionUtil<FormTemplate>{
	private static final long serialVersionUID = -1840240639639068834L;
	
	@Resource(name="formTemplateService")
	private FormTemplateService formTemplateServ;
	
	@Resource(name="procDefManager")
	private ProcDefManager pdManager;
	
	private File resource;
	
	public File getResource() {
		return resource;
	}
	public void setResource(File resource) {
		this.resource = resource;
	}

	public String showAllList(){
		Collection<FormTemplate> ftList = this.formTemplateServ.getAllElements();
		ActionContext.getContext().put("ftList", ftList);
		return list;
	}
	
	public String addWeb(){
		Collection<ProcessDefinition> pdList = this.pdManager.showLatestVersions();
		ActionContext.getContext().put("pdList", pdList);
		return addWeb;
	}
	
	public String add(){
		this.formTemplateServ.saveFormTemplate(this.getModel(), resource);
		return jumpAction;
	}
}
