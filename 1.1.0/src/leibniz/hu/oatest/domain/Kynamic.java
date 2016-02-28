package leibniz.hu.oatest.domain;

import java.util.Set;

public class Kynamic {
	//数据库字段
	private Long kid;
	private Long pid;
	private String kname;
	private Boolean isParent;
	//与版本是一对多的关系
	private Set<Version> versions;

	//getter和setter
	public Long getKid() {
		return kid;
	}
	public void setKid(Long kid) {
		this.kid = kid;
	}
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public String getKname() {
		return kname;
	}
	public void setKname(String kname) {
		this.kname = kname;
	}
	public Boolean getIsParent() {
		return isParent;
	}
	public void setIsParent(Boolean isParent) {
		this.isParent = isParent;
	}
	public Set<Version> getVersions() {
		return versions;
	}
	public void setVersions(Set<Version> versions) {
		this.versions = versions;
	}
}
