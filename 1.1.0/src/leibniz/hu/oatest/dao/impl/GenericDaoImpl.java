package leibniz.hu.oatest.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import leibniz.hu.oatest.dao.GenericDao;

public class GenericDaoImpl<T> implements GenericDao<T>{

	@Resource(name="hibernateTemplate")
	public HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

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
