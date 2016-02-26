package leibniz.hu.oatest.action;

import java.util.Collection;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.struts2.json.annotations.JSON;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import leibniz.hu.oatest.domain.Menu;
import leibniz.hu.oatest.domain.User;
import leibniz.hu.oatest.service.MenuService;
import leibniz.hu.oatest.service.UserService;
import leibniz.hu.oatest.utils.OaUtils;

@Controller("menuAction")
@Scope("prototype")
public class MenuAction extends ActionUtil<Menu>{

	private static final long serialVersionUID = -8633846661190971387L;

	@Resource(name="menuService")
	private MenuService menuServ;
	
	@Resource(name="userService")
	private UserService userServ;
	
	private Collection<Menu> menuList;
	public Collection<Menu> getMenuList() {
		return menuList;
	}
	
	private Long uid;
	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
	}
	
	private String mids;
	public String getMids() {
		return mids;
	}
	public void setMids(String mids) {
		this.mids = mids;
	}
	
	@JSON(serialize=false)
	public String getAllMenus(){
		this.menuList = this.menuServ.getAllElements();
		return SUCCESS;
	}

	@JSON(serialize=false)
	public String getMenusByPid(){
		this.menuList = this.menuServ.getMenusByPid(this.getModel().getPid());
		return SUCCESS;
	}
	
	@JSON(serialize=false)
	public String getMenusByUid(){
		this.menuList = this.menuServ.getMenusByUid(this.uid);
		return SUCCESS;
	}
	
	public String savePermission(){
		//根据传回的uid获取user对象
		User user = this.userServ.getElementById(this.uid);
		//根据传回的mids数组（拼接成字符串）查询对应的菜单项
		Set<Menu> menus = this.menuServ.getMenusByIds(OaUtils.string2Longs(mids));
		//将这些菜单项保存到user中
		user.setMenus(menus);
		this.userServ.updateElement(user);
		return SUCCESS;
	}
}
