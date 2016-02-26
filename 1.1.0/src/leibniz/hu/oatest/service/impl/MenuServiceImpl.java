package leibniz.hu.oatest.service.impl;

import java.util.Collection;
import java.util.Set;

import javax.annotation.Resource;

import leibniz.hu.oatest.dao.GenericDao;
import leibniz.hu.oatest.dao.MenuDao;
import leibniz.hu.oatest.domain.Menu;
import leibniz.hu.oatest.service.MenuService;

import org.springframework.stereotype.Service;

@Service("menuService")
public class MenuServiceImpl extends GenericServiceImpl<Menu> implements MenuService{

	@Resource(name="menuDao")
	public void initDao(GenericDao<Menu> dao){
		super.setDao(dao);
	}
	
	@Override
	public Collection<Menu> getMenusByPid(Long pid) {
		return ((MenuDao)this.dao).getMenusByPid(pid);
	}

	@Override
	public Collection<Menu> getMenusByUid(Long uid) {
		return ((MenuDao)this.dao).getMenusByUid(uid);
	}

	@Override
	public Set<Menu> getMenusByIds(Long[] ids) {
		return ((MenuDao)this.dao).getMenusByIds(ids);
	}

}
