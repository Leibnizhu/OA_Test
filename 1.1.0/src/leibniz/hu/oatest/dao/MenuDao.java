package leibniz.hu.oatest.dao;

import java.util.Collection;

import leibniz.hu.oatest.domain.Menu;

public interface MenuDao extends GenericDao<Menu>{
	public Collection<Menu> getMenusByPid(Long pid);
}
