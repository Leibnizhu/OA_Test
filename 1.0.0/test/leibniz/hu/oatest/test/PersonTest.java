package leibniz.hu.oatest.test;

import org.junit.Test;

import leibniz.hu.oatest.domain.Person;
import leibniz.hu.oatest.service.PersonService;

public class PersonTest extends SpringUtil{
	@Test
	public void testSavePerson(){
		PersonService pServ = (PersonService) ctx.getBean("personService");
		Person person = new Person();
		person.setPname("Jeff");
		pServ.savePerson(person);
	}
}
