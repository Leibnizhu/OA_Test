package leibniz.hu.oatest.test;

import leibniz.hu.oatest.domain.Kynamic;
import leibniz.hu.oatest.service.KynamicService;

import org.junit.Test;

public class KynamicTest extends SpringUtils{
	@Test
	public void testSaveKynamic(){
		
		Kynamic kynamic = new Kynamic();
		kynamic.setIsParent(true);
		kynamic.setKname("知识管理");
		kynamic.setPid(0L);
		KynamicService kynamicService = (KynamicService) context.getBean("kynamicService");
		kynamicService.saveElement(kynamic);
	}
}
