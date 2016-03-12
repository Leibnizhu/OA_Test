package leibniz.hu.oatest.test;

import org.hibernate.SessionFactory;
import org.junit.Test;

public class SessionFactoryTest extends SpringUtils{
	@Test
	public void testSF(){
		SessionFactory sf = (SessionFactory)context.getBean("sessionFactory");
	}
}
