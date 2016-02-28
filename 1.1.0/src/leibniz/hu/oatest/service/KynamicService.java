package leibniz.hu.oatest.service;

import leibniz.hu.oatest.domain.Kynamic;

public interface KynamicService extends GenericService<Kynamic>{
	public Boolean isNameExists(String kname);
}
