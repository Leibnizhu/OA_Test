package leibniz.hu.oatest.dao;

import leibniz.hu.oatest.domain.Kynamic;

public interface KynamicDao extends GenericDao<Kynamic>{
	public Kynamic getKynamicByKname(String kname);
}
