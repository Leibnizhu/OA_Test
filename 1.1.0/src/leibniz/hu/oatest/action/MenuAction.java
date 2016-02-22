package leibniz.hu.oatest.action;

import java.util.Collection;

import javax.annotation.Resource;

import org.apache.struts2.json.annotations.JSON;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import leibniz.hu.oatest.domain.Menu;
import leibniz.hu.oatest.service.MenuService;

@Controller("menuAction")
@Scope("prototype")
public class MenuAction extends ActionUtil<Menu>{

	private static final long serialVersionUID = -8633846661190971387L;

	@Resource(name="menuService")
	private MenuService menuServ;
	private Collection<Menu> menuList;
	
	public Collection<Menu> getMenuList() {
		return menuList;
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
}
