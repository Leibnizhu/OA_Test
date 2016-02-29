package leibniz.hu.oatest.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import leibniz.hu.oatest.dao.GenericDao;
import leibniz.hu.oatest.dao.VersionDao;
import leibniz.hu.oatest.domain.Version;
import leibniz.hu.oatest.service.VersionService;

@Service("versionService")
public class VersionServiceImpl extends GenericServiceImpl<Version> implements VersionService{
	@Resource(name="versionDao")
	public void initDao(GenericDao<Version> dao){
		super.dao = dao;
	}

	@Override
	public Long getMaxVersionByKid(Long kid) {
		return ((VersionDao)dao).getMaxVersionByKid(kid);
	}
}
