package leibniz.hu.oatest.dao.impl;

import java.io.Serializable;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import leibniz.hu.oatest.dao.PersonDao;
import leibniz.hu.oatest.domain.Person;

public class PersonDaoImpl extends HibernateDaoSupport implements PersonDao{

	@Override
	public void savePerson(Person person) {
		this.getHibernateTemplate().save(person);
	}

	@Override
	public Person getPersonById(Serializable id) {
		return (Person) this.getHibernateTemplate().load(Person.class, id);
	}

}
