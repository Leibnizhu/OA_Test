package leibniz.hu.oatest.dao;

import java.io.Serializable;
import java.util.Collection;

public interface GenericDao<T> {
	//增
	public void saveElement(T element);
	//删
	public void deleteElement(T element);
	//改
	public void updateElement(T element);
	//查
	//根据ID查一个
	public T getElementById(Serializable id);
	//查出所有
	public Collection<T> getAllElements();
}
