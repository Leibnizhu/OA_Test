package leibniz.hu.oatest.domain;

import java.io.Serializable;
import java.util.Date;

public class Approval implements Serializable{
	private static final long serialVersionUID = 3743791282998940989L;

	private Long aid;
	private String approver;
	private Date approveTime;
	private String isAgree;
	private String comment;
	
	//与申请单是多对一的关系
	private Form form;

	//Getter and Setter
	public Long getAid() {
		return aid;
	}

	public void setAid(Long aid) {
		this.aid = aid;
	}

	public String getApprover() {
		return approver;
	}

	public void setApprover(String approver) {
		this.approver = approver;
	}

	public Date getApproveTime() {
		return approveTime;
	}

	public void setApproveTime(Date approveTime) {
		this.approveTime = approveTime;
	}

	public String getIsAgree() {
		return isAgree;
	}

	public void setIsAgree(String isAgree) {
		this.isAgree = isAgree;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Form getForm() {
		return form;
	}

	public void setForm(Form form) {
		this.form = form;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
