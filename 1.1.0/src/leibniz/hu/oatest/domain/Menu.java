package leibniz.hu.oatest.domain;

import java.util.Set;

import org.apache.struts2.json.annotations.JSON;

public class Menu {
	//数据库自身字段
	//menu Id
	private Long mid;
	//父节点Id
	private Long pid;
	//节点名字
	private String mname;
	//是否为父节点
	private Boolean isParent;
	//图标路径
	private String icon;
	//是否被选中
	private Boolean isChecked;
	
	//与User是多对多的关系，一个用户可以有多个菜单项(权限)，多个用户又可以共同拥有同一个权限
	private Set<User> users;

	//Setter和Getter
	public Long getMid() {
		return mid;
	}

	public void setMid(Long mid) {
		this.mid = mid;
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public Boolean getIsParent() {
		return isParent;
	}

	public void setIsParent(Boolean isParent) {
		this.isParent = isParent;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Boolean getIsChecked() {
		return isChecked;
	}

	public void setIsChecked(Boolean isChecked) {
		this.isChecked = isChecked;
	}

	@JSON(serialize=false)
	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
}
