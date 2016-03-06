package leibniz.hu.oatest.test;

import org.jbpm.api.ProcessEngine;
import org.junit.Test;

public class ProcessEngineTest extends SpringUtils{
	@Test
	public void test(){
		ProcessEngine pe =(ProcessEngine) context.getBean("processEngine"); 
		System.out.println(pe);
	}
}
