package leibniz.hu.oatest.service;

import java.io.Serializable;
import java.util.Collection;

import leibniz.hu.oatest.dao.GenericDao;

import org.springframework.transaction.annotation.Transactional;

public interface GenericService<T> {
	public void setDao(GenericDao<T> dao);
	//增
	@Transactional(readOnly=false)
	public void saveElement(T element);
	//删
	@Transactional(readOnly=false)
	public void deleteElement(T element);
	//改
	@Transactional(readOnly=false)
	public void updateElement(T element);
	//查
	//根据ID查一个
	public T getElementById(Serializable id);
	//查出所有
	public Collection<T> getAllElements();
}
