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

import leibniz.hu.oatest.dao.FormDao;
import leibniz.hu.oatest.dao.FormTemplateDao;
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
	private FormDao formDao;
	
	@Resource(name="formTemplateDao")
	private FormTemplateDao ftDao;
	
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
		this.formDao.saveElement(form);
		
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
	
}
