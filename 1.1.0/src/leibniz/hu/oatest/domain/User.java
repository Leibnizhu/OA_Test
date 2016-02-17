package leibniz.hu.oatest.domain;

import java.util.Set;

public class User {
	//数据库中的字段
	private Long uid;
	private String username;
	private String password;
	private String gender;
	private String tel;
	private String email;
	
	//用于Hibernate映射的成员属性
	private Department department;
	private Set<Job> jobs;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Set<Job> getJobs() {
		return jobs;
	}
	public void setJobs(Set<Job> jobs) {
		this.jobs = jobs;
	}
	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
}
