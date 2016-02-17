package leibniz.hu.oatest.dao.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import leibniz.hu.oatest.dao.UserDao;
import leibniz.hu.oatest.domain.User;

import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao{
	@SuppressWarnings("unchecked")
	public Collection<User> getAllUsers(){
		String sql = "from User u left join fetch u.department d left join fetch u.jobs j";
		List<User> userList = this.getHibernateTemplate().find(sql);
		return new HashSet<User>(userList);
	}
}
