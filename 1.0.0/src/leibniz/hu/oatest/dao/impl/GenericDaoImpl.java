package leibniz.hu.oatest.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import leibniz.hu.oatest.dao.GenericDao;

public class GenericDaoImpl<T> extends HibernateDaoSupport implements GenericDao<T>{

	@SuppressWarnings("rawtypes")
	private Class curClass;
	
	@SuppressWarnings("rawtypes")
	public GenericDaoImpl() {
		super();
		ParameterizedType pmType = (ParameterizedType) this.getClass().getGenericSuperclass();
		curClass = (Class) pmType.getActualTypeArguments()[0];
	}
	
	@Override
	public void saveElement(Object element) {
		this.getHibernateTemplate().save(element);
	}

	@Override
	public void deleteElement(Object element) {
		this.getHibernateTemplate().delete(element);
	}

	@Override
	public void updateElement(Object element) {
		this.getHibernateTemplate().update(element);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getElementById(Serializable id) {
		return (T) this.getHibernateTemplate().get(this.curClass, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<T> getAllElements() {
		return this.getHibernateTemplate().find("from " + this.curClass.getName());
	}

}
