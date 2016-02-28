package leibniz.hu.oatest.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import leibniz.hu.oatest.dao.KynamicDao;
import leibniz.hu.oatest.domain.Kynamic;

@Repository("kynamicDao")
public class KynamicDaoImpl extends GenericDaoImpl<Kynamic> implements KynamicDao{
	@SuppressWarnings("unchecked")
	@Override
	public Kynamic getKynamicByKname(String kname) {
		List<Kynamic> kynamicList = this.getHibernateTemplate().find("from Kynamic where kname=?", kname);
		if(kynamicList.size() == 0){
			return null;
		} else {
			return kynamicList.get(0);
		}
	}

}
