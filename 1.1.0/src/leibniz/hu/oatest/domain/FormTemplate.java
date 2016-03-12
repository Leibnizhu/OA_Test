package leibniz.hu.oatest.domain;

import java.io.Serializable;
import java.util.Set;

public class FormTemplate implements  Serializable{
	private static final long serialVersionUID = 959889469274062875L;
	
	private Long ftid;
	private String ftname;
	//pdkey
	private String procDefKey;
	//存放路径
	private String url;
	
	//与具体表单是一对多关系
	private Set<Form> forms;

	//Getter and Setter
	public Long getFtid() {
		return ftid;
	}

	public void setFtid(Long ftid) {
		this.ftid = ftid;
	}

	public String getFtname() {
		return ftname;
	}

	public void setFtname(String ftname) {
		this.ftname = ftname;
	}

	public String getProcDefKey() {
		return procDefKey;
	}

	public void setProcDefKey(String procDefKey) {
		this.procDefKey = procDefKey;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Set<Form> getForms() {
		return forms;
	}

	public void setForms(Set<Form> forms) {
		this.forms = forms;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
