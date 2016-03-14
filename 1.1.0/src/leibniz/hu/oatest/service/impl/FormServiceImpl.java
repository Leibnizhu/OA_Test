package leibniz.hu.oatest.service.impl;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.jbpm.api.ProcessEngine;
import org.jbpm.api.ProcessInstance;
import org.jbpm.api.task.Task;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import leibniz.hu.oatest.dao.ApprovalDao;
import leibniz.hu.oatest.dao.FormDao;
import leibniz.hu.oatest.dao.FormTemplateDao;
import leibniz.hu.oatest.dao.GenericDao;
import leibniz.hu.oatest.domain.Approval;
import leibniz.hu.oatest.domain.Form;
import leibniz.hu.oatest.domain.FormTemplate;
import leibniz.hu.oatest.domain.TaskView;
import leibniz.hu.oatest.domain.User;
import leibniz.hu.oatest.service.FormService;
import leibniz.hu.oatest.utils.OaUtils;
import leibniz.hu.oatest.utils.UploadUtils;

@Service("formService")
public class FormServiceImpl extends GenericServiceImpl<Form> implements FormService{
	
	@Resource(name="formDao")
	public void initDao(GenericDao<Form> dao){
		super.dao = dao;
	}
	
	@Resource(name="formTemplateDao")
	private FormTemplateDao ftDao;
	
	@Resource(name="approvalDao")
	private ApprovalDao approvalDao;
	
	@Resource(name="processEngine")
	private ProcessEngine procEng;

	@Override
	@Transactional(readOnly=false)
	public void submit(Long ftid, File resource) {
		//上传表单
		String url = UploadUtils.saveUploadFile(resource);
		
		//组装form所需的原材料
		Date curDate = new Date();
		User user = OaUtils.getUserFromSession();
		FormTemplate ft = this.ftDao.getElementById(ftid);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//拼装form对象
		Form form = new Form();
		form.setApproveTime(curDate);
		form.setApplicant(user.getUsername());
		form.setState("申请ing");
		form.setUrl(url);
		form.setTitle(ft.getFtname() + "_" + user.getUsername() + "_" + sdf.format(curDate));
		form.setFormTemplate(ft);
		//往form表插入数据
		((FormDao)super.dao).saveElement(form);
		
		//JBPM操作
		//设置流程变量，form
		Map<String, Form> vars = new HashMap<String, Form>();
		vars.put("form", form);
		//启动流程实例
		ProcessInstance procIn = this.procEng.getExecutionService().startProcessInstanceByKey(ft.getProcDefKey(), vars);
		//根据流程实例id，查询当前流程实例对应的当前任务
		Task task = this.procEng.getTaskService().createTaskQuery().executionId(procIn.getId()).uniqueResult();
		//完成第一个任务
		this.procEng.getTaskService().completeTask(task.getId());
	}

	@Override
	public Collection<TaskView> getAllFormByAssign() {
		Collection<TaskView> taskViewList = new ArrayList<TaskView>();
		//先获得当前用户对应的所有任务
		User user = OaUtils.getUserFromSession();
		Collection<Task> taskList = this.procEng.getTaskService().createTaskQuery().assignee(user.getUsername()).list();
		//遍历所有对应的Task
		for(Task task : taskList){
			//从流程变量获得对应的Form
			Form form = (Form) this.procEng.getExecutionService().getVariable(task.getExecutionId(), "form");
			//组成TaskView并放入Collection中
			TaskView taskView = new TaskView();
			taskView.setForm(form);
			taskView.setTask(task);
			taskViewList.add(taskView);
		}
		return taskViewList;
	}

	@Override
	@Transactional(readOnly = false)
	public void approve(String taskId, Approval approval) {
		//先获取Task
		Task task = this.procEng.getTaskService().getTask(taskId);
		if("不同意".equals(approval.getIsAgree())){
			//不同意，则流程直接结束
			this.procEng.getExecutionService().endProcessInstance(task.getExecutionId(), "ended");
			//form对象的状态也相应改成"未通过"
			approval.getForm().setState("未通过");
		} else if("同意".equals(approval.getIsAgree())){
			//若同意，则先完成当前任务
			this.procEng.getTaskService().completeTask(taskId);
			//再获取当前的流程实例
			ProcessInstance pi = this.procEng.getExecutionService().createProcessInstanceQuery().processInstanceId(task.getExecutionId()).uniqueResult();
			if(null == pi){
				//若原流程实例为空，即前面完成task之后，关闭了流程实例，即流程实例已完成，应修改form的状态
				approval.getForm().setState("已通过");
			}
		} else {
			//页面返回只能是"同意"或者"不同意"，其他一概忽略
			return;
		}
		//如果有正确的isAgree，则保存approval
		this.approvalDao.saveElement(approval);
	}
	
}
