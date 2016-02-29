package leibniz.hu.oatest.dao.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Repository;

import leibniz.hu.oatest.dao.KynamicDao;
import leibniz.hu.oatest.domain.Kynamic;
import leibniz.hu.oatest.domain.Version;

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

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Version> getVersionsByKid(Long kid) {
		Collection<Version> kynamicList = this.getHibernateTemplate().find("from Version where kid = ?", kid);
		return kynamicList;
	}

}
