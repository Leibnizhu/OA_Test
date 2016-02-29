package leibniz.hu.oatest.dao.impl;

import java.util.List;

import leibniz.hu.oatest.dao.VersionDao;
import leibniz.hu.oatest.domain.Version;

import org.springframework.stereotype.Repository;

@Repository("versionDao")
public class VersionDaoImpl extends GenericDaoImpl<Version> implements VersionDao{

	public Long getMaxVersionByKid(Long kid) {
		@SuppressWarnings("unchecked")
		List<Long> list = this.getHibernateTemplate().find("select max(v.version) from Version v where kid=?", kid);
		if(list.size() == 0){
			return 0L;
		} else {
			if(null != list.get(0)){
				return  list.get(0);
			} else {
				return 0L;
			}
		}
	}

}
