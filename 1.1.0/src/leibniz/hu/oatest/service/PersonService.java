package leibniz.hu.oatest.service;

import java.io.Serializable;

import leibniz.hu.oatest.domain.Person;

public interface PersonService {
	public void savePerson(Person person);
	
	public Person getPersonById(Serializable id);
}
