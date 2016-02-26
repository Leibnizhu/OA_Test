package leibniz.hu.oatest.dao;

import java.util.Collection;
import java.util.Set;

import leibniz.hu.oatest.domain.Menu;

public interface MenuDao extends GenericDao<Menu>{
	public Collection<Menu> getMenusByPid(Long pid);
	public Collection<Menu> getMenusByUid(Long uid);
	public Set<Menu> getMenusByIds(Long[] ids);
}
