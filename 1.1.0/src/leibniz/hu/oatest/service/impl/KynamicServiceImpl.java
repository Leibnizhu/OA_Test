package leibniz.hu.oatest.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import leibniz.hu.oatest.dao.GenericDao;
import leibniz.hu.oatest.dao.KynamicDao;
import leibniz.hu.oatest.domain.Kynamic;
import leibniz.hu.oatest.service.KynamicService;

@Service("kynamicService")
public class KynamicServiceImpl extends GenericServiceImpl<Kynamic> implements KynamicService{
	@Resource(name="kynamicDao")
	public void initDao(GenericDao<Kynamic> dao){
		super.dao = dao;
	}

	@Override
	public Boolean isNameExists(String kname) {
		Kynamic kynamic = ((KynamicDao)dao).getKynamicByKname(kname);
		return kynamic==null?false:true;
	}
}
