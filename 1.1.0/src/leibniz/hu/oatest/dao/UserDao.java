package leibniz.hu.oatest.dao;

import java.util.Collection;

import leibniz.hu.oatest.domain.User;

public interface UserDao extends GenericDao<User>{
	public Collection<User> getAllUsers();
	public User getUserByNameNPswd(String username, String password);
}
