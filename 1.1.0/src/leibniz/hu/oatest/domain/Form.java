package leibniz.hu.oatest.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class Form implements Serializable{
	private static final long serialVersionUID = -5636080007407520800L;

	private Long fid;
	private String title;
	private String applicant;
	private Date approveTime;
	private String state;
	
	//与审批是一对多的关系
	private Set<Approval> approvals;
	//与申请单模板是多对一的关系
	private FormTemplate formTemplate;

	//Getter and Setter
	public FormTemplate getFormTemplate() {
		return formTemplate;
	}

	public void setFormTemplate(FormTemplate formTemplate) {
		this.formTemplate = formTemplate;
	}

	public Long getFid() {
		return fid;
	}

	public void setFid(Long fid) {
		this.fid = fid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getApplicant() {
		return applicant;
	}

	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}

	public Date getApproveTime() {
		return approveTime;
	}

	public void setApproveTime(Date approveTime) {
		this.approveTime = approveTime;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Set<Approval> getApprovals() {
		return approvals;
	}

	public void setApprovals(Set<Approval> approvals) {
		this.approvals = approvals;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
