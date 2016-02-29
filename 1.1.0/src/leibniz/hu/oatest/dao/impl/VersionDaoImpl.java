package leibniz.hu.oatest.dao.impl;

import leibniz.hu.oatest.dao.VersionDao;
import leibniz.hu.oatest.domain.Version;

import org.springframework.stereotype.Repository;

@Repository("versionDao")
public class VersionDaoImpl extends GenericDaoImpl<Version> implements VersionDao{

}
