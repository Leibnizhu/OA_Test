package leibniz.hu.oatest.domain;

import org.jbpm.api.task.Task;

public class TaskView {
	private Task task;
	private Form form;
	public Task getTask() {
		return task;
	}
	public void setTask(Task task) {
		this.task = task;
	}
	public Form getForm() {
		return form;
	}
	public void setForm(Form form) {
		this.form = form;
	}
}
