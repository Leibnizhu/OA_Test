package leibniz.hu.oatest.test;

import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringUtil {
	public static ApplicationContext ctx;
	@Before
	public void startSpring() {
			ctx = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
	}
}
