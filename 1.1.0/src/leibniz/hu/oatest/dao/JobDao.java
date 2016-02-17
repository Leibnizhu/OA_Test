package leibniz.hu.oatest.dao;

import java.util.Set;

import leibniz.hu.oatest.domain.Job;

public interface JobDao extends GenericDao<Job>{
	public Set<Job> getJobsByIds(Long[] ids);
}
