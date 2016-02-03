package leibniz.hu.oatest.domain;

import java.util.Set;

public class Job {
	//数据库字段
	private Long jid;
	private String jname;
	private String jdescript;
	
	//用于Hibernate映射的成员属性，岗位对用户是多对多（略显牵强哦，一个用户一般就一个职位）
	private Set<User> users;

	public Long getJid() {
		return jid;
	}

	public void setJid(Long jid) {
		this.jid = jid;
	}

	public String getJname() {
		return jname;
	}

	public void setJname(String jname) {
		this.jname = jname;
	}

	public String getJdescript() {
		return jdescript;
	}

	public void setJdescript(String jdescript) {
		this.jdescript = jdescript;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
}
