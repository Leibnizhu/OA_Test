package leibniz.hu.oatest.service.impl;

import java.io.Serializable;

import leibniz.hu.oatest.dao.PersonDao;
import leibniz.hu.oatest.domain.Person;
import leibniz.hu.oatest.service.PersonService;

public class PersonServiceImpl implements PersonService{
	private PersonDao personDao;
	
	public PersonDao getPersonDao() {
		return personDao;
	}

	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}

	@Override
	public void savePerson(Person person) {
		this.personDao.savePerson(person);
		}

	@Override
	public Person getPersonById(Serializable id) {
		return this.personDao.getPersonById(id);
		}

}
