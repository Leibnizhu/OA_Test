package leibniz.hu.oatest.service;

import java.util.Set;

import leibniz.hu.oatest.domain.Job;

public interface JobService extends GenericService<Job>{
	public Set<Job> getJobsByIds(Long[] ids);
}
