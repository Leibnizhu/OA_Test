package leibniz.hu.oatest.service.impl;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import leibniz.hu.oatest.dao.GenericDao;
import leibniz.hu.oatest.dao.UserDao;
import leibniz.hu.oatest.domain.User;
import leibniz.hu.oatest.service.UserService;

@Service("userService")
public class UserServiceImpl extends GenericServiceImpl<User> implements UserService{
	@Resource(name="userDao")
	public void initDao(GenericDao<User> dao){
		super.setDao(dao);
	}

	@Override
	public Collection<User> getAllUsers() {
		return ((UserDao)this.dao).getAllUsers();
	}

	@Override
	public User getUserByNameNPswd(String username, String password) {
		return ((UserDao)this.dao).getUserByNameNPswd(username, password);
	}
}
