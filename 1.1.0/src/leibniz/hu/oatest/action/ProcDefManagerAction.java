package leibniz.hu.oatest.action;

import java.io.File;
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
	private InputStream inputStream;
	//根据pdkey删除流程定义
	private String key;
	//保存上传的zip文件
	private File procDefZip;
	
	//字段对应的getter和setter
	public String getDeploymentId() {
		return deploymentId;
	}
	public void setDeploymentId(String deploymentId) {
		this.deploymentId = deploymentId;
	}
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public File getProcDefZip() {
		return procDefZip;
	}
	public void setProcDefZip(File procDefZip) {
		this.procDefZip = procDefZip;
	}
	 
	//以下是Action方法们
	//显示所有流程定义（最新版本）
	public String showLatestVersions(){
		Collection<ProcessDefinition> procDefList = this.procDefManager.showLatestVersions();
		ActionContext.getContext().put("procDefList", procDefList);
		return "list";
	}
	
	//删除流程定义
	public String delete(){
		this.procDefManager.deleteByPDKey(this.key);
		return "jumpAction";
	}
	
	//获取流程定义图
	public String showImage(){
		this.inputStream = this.procDefManager.showProcDefImg(this.deploymentId);
		return SUCCESS;
	}
	
	//跳转到部署流程定义的web
	public String deployWeb(){
		return "deployWeb";
	}
	
	//部署流程定义
	public String deploy(){
		this.procDefManager.deploy(this.procDefZip);
		return "jumpAction";
	}
}
