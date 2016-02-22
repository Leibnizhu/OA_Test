package leibniz.hu.oatest.dao.impl;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import leibniz.hu.oatest.dao.MenuDao;
import leibniz.hu.oatest.domain.Menu;

@Repository("menuDao")
public class MenuDaoImpl extends GenericDaoImpl<Menu> implements MenuDao{

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Menu> getMenusByPid(Long pid) {
		return (Collection<Menu>)(this.getHibernateTemplate().find("from Menu where pid = ?", pid));
	}

}
