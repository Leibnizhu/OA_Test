package leibniz.hu.oatest.test;

import org.hibernate.SessionFactory;
import org.junit.Test;

public class SessionFactoryTest extends SpringUtil{
	@Test
	public void sessionFactoryTest(){
		SessionFactory sf = (SessionFactory)ctx.getBean("sessionFactory");
		System.out.println(sf);
	}
}
