package leibniz.hu.oatest.service;

import java.util.Collection;

import leibniz.hu.oatest.domain.Kynamic;
import leibniz.hu.oatest.domain.Version;

public interface KynamicService extends GenericService<Kynamic>{
	public Boolean isNameExists(String kname);
	public Collection<Version> getVersionsByKid(Long kid);
}
