package leibniz.hu.oatest.action;

import java.io.InputStream;
import java.util.Collection;

import javax.annotation.Resource;

import leibniz.hu.oatest.service.ProcDefManager;

import org.jbpm.api.ProcessDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@Controller("procDefManagerAction")
@Scope("prototype")
public class ProcDefManagerAction extends ActionSupport {
	private static final long serialVersionUID = -3080941387239927658L;
	
	@Resource(name="procDefManager")
	private ProcDefManager procDefManager;
	
	//页面相关字段
	//查询流程定义图
	private String deploymentId;
	//返回流程图用的输入流
	private InputStream inputstream;
	//根据pdkey删除流程定义
	private String key;
	
	//字段对应的getter和setter
	public String getDeploymentId() {
		return deploymentId;
	}
	public void setDeploymentId(String deploymentId) {
		this.deploymentId = deploymentId;
	}
	public InputStream getInputstream() {
		return inputstream;
	}
	public void setInputstream(InputStream inputstream) {
		this.inputstream = inputstream;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	
	//以下是Action方法们
	public String showLatestVersions(){
		Collection<ProcessDefinition> procDefList = this.procDefManager.showLatestVersions();
		ActionContext.getContext().put("procDefList", procDefList);
		return "list";
	}
	

	public String delete(){
		this.procDefManager.deleteByPDKey(this.key);
		return "jumpAction";
	}
	
	public String showImage(){
		this.inputstream = this.procDefManager.showProcDefImg(this.deploymentId);
		return SUCCESS;
	}
}
