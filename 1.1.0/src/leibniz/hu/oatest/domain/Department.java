package leibniz.hu.oatest.domain;

import java.util.Set;

public class Department {
	//数据库字段
	private Long did;
	private String dname;
	private String ddescript;
	
	//用于Hibernate映射的成员属性，部门对用户是一对多
	private Set<User> users;

	public Long getDid() {
		return did;
	}

	public void setDid(Long did) {
		this.did = did;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getDdescript() {
		return ddescript;
	}

	public void setDdescript(String ddescript) {
		this.ddescript = ddescript;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
}
