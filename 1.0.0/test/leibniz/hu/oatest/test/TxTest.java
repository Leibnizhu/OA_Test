package leibniz.hu.oatest.test;

import leibniz.hu.oatest.dao.PersonDao;
import leibniz.hu.oatest.domain.Person;
import leibniz.hu.oatest.service.PersonService;

import org.junit.Test;

public class TxTest extends SpringUtil{
	//直接调用dao，没有事务
	@Test
	public void daoNonTxTest(){
		PersonDao pd = (PersonDao)ctx.getBean("personDao");
		Person p = pd.getPersonById(2L);
		System.out.println(p.getPname());
	}
	
	//service，有事务
	@Test
	public void serviceTxTest(){
		PersonService ps = (PersonService)ctx.getBean("personService");
		System.out.println("service");
		Person p = ps.getPersonById(2L);
		System.out.println(p.getPname());
	}
}
