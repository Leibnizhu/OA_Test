package leibniz.hu.oatest.service.impl;

import java.io.Serializable;
import java.util.Collection;

import leibniz.hu.oatest.dao.GenericDao;
import leibniz.hu.oatest.service.GenericService;

public class GenericServiceImpl<T> implements GenericService<T>{
	public GenericDao<T> dao;
	
	@Override
	public void saveElement(T element) {
		this.dao.saveElement(element);
	}

	@Override
	public void deleteElement(T element) {
		this.dao.deleteElement(element);
	}

	@Override
	public void updateElement(T element) {
		this.dao.updateElement(element);
	}

	@Override
	public T getElementById(Serializable id) {
		return this.dao.getElementById(id);
	}

	@Override
	public Collection<T> getAllElements() {
		return this.dao.getAllElements();
	}

	@Override
	public void setDao(GenericDao<T> dao) {
		this.dao = dao;
	}
}
