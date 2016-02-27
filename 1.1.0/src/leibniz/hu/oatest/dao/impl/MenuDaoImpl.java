package leibniz.hu.oatest.dao.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	
	
	public Set<Menu> getMenusByIds(Long[] ids){
		//根据id数组拼接成SQL/HQL查询语句
		StringBuffer sbSql = new StringBuffer();
		sbSql.append("from Menu where mid in (");
		for(int i = 0; i < ids.length; i++){
			sbSql.append(ids[i]);
			if(i != ids.length - 1){
				sbSql.append(",");
			}
		}
		sbSql.append(")");
		System.out.println(sbSql.toString());
		//通过HibernateTemplate查询
		@SuppressWarnings("unchecked")
		List<Menu> menuList = this.getHibernateTemplate().find(sbSql.toString());
		//通过Map去掉重复项
		return new HashSet<Menu>(menuList);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Menu> getMenusByUser(User user) {
		if("admin".equals( user.getUsername())){
			return this.getAllElements();
		} else {
			return (Collection<Menu>)(this.getHibernateTemplate().find("from Menu m inner join fetch  m.users u where u.uid=?", user.getUid()));
		}
	}

}
