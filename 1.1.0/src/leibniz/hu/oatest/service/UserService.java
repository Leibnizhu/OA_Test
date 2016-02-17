package leibniz.hu.oatest.service;

import java.util.Collection;

import leibniz.hu.oatest.domain.User;

public interface UserService extends GenericService<User>{
	public Collection<User> getAllUsers();
}
