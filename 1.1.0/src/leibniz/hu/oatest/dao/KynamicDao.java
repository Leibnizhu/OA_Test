package leibniz.hu.oatest.dao;

import java.util.Collection;

import leibniz.hu.oatest.domain.Kynamic;
import leibniz.hu.oatest.domain.Version;

public interface KynamicDao extends GenericDao<Kynamic>{
	public Kynamic getKynamicByKname(String kname);

	public Collection<Version> getVersionsByKid(Long kid);
}
