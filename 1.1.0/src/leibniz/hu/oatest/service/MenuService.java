package leibniz.hu.oatest.service;

import java.util.Collection;

import leibniz.hu.oatest.domain.Menu;

public interface MenuService extends GenericService<Menu>{
	public Collection<Menu> getMenusByPid(Long pid);
}
