package leibniz.hu.oatest.service;

import java.io.File;
import java.util.Collection;

import leibniz.hu.oatest.domain.Approval;
import leibniz.hu.oatest.domain.Form;
import leibniz.hu.oatest.domain.TaskView;

public interface FormService extends GenericService<Form>{
	public void submit(Long ftid, File resource);
	//根据当前用户返回Form和对应当前Task的列表
	public Collection<TaskView> getAllFormByAssign();
	//审批任务
	public void approve(String taskId, Approval approval);
}
