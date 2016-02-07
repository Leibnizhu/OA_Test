package leibniz.hu.oatest.service.impl;

import java.io.Serializable;
import java.util.Collection;

import leibniz.hu.oatest.dao.GenericDao;
import leibniz.hu.oatest.service.GenericService;

public class GenericServiceImpl<T> implements GenericService<T>{
	private GenericDao<T> gDao;
	
	public GenericDao<T> getGdao() {
		return gDao;
	}

	public void setGdao(GenericDao<T> gDao) {
		this.gDao = gDao;
	}

	@Override
	public void saveElement(T element) {
		this.gDao.saveElement(element);
	}

	@Override
	public void deleteElement(T element) {
		this.gDao.deleteElement(element);
	}

	@Override
	public void updateElement(T element) {
		this.gDao.updateElement(element);
	}

	@Override
	public T getElementById(Serializable id) {
		return this.gDao.getElementById(id);
	}

	@Override
	public Collection<T> getAllElements() {
		return this.gDao.getAllElements();
	}
}
