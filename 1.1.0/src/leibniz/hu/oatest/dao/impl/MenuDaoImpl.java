package leibniz.hu.oatest.dao.impl;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import leibniz.hu.oatest.dao.MenuDao;
import leibniz.hu.oatest.dao.UserDao;
import leibniz.hu.oatest.domain.Menu;
import leibniz.hu.oatest.domain.User;

@Repository("menuDao")
public class MenuDaoImpl extends GenericDaoImpl<Menu> implements MenuDao{

	@Resource(name="userDao")
	private UserDao userDao;
	
	@SuppressWarnings("unchecked")
	@Override
	public Collection<Menu> getMenusByPid(Long pid) {
		return (Collection<Menu>)(this.getHibernateTemplate().find("from Menu where pid = ?", pid));
	}

	@Override
	public Collection<Menu> getMenusByUid(Long uid) {
		//先根据uid获取user对象
		User user = this.userDao.getElementById(uid);
		//再获取所有菜单项
		Collection<Menu> menuList = this.getAllElements();
		//通过内查询查出当前用户拥有的菜单项，遍历找到对应的菜单项将checked设置为true
		@SuppressWarnings("unchecked")
		Collection<Menu> ownMenuList = this.hibernateTemplate.find("from Menu m inner join fetch  m.users u where u.uid=?", uid);
		if("admin".equals( user.getUsername())){
			//如果是admin则所有菜单都是选中的
			for(Menu menu : menuList){
				menu.setIsChecked(true);
			}
		} else {
			//否则根据ownMenuList查询到的结果遍历之
			for(Menu ownMenu : ownMenuList){
				for(Menu menu : menuList){
					if(ownMenu.getMid().longValue() == menu.getMid().longValue()){
						menu.setIsChecked(true);
					}
				}
			}
		}
		return menuList;
	}

}
