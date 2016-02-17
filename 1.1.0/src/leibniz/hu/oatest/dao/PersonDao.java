package leibniz.hu.oatest.dao;

import java.io.Serializable;

import leibniz.hu.oatest.domain.Person;

public interface PersonDao {
	public void savePerson(Person person);
	
	public Person getPersonById(Serializable id);
}
