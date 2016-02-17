package leibniz.hu.oatest.service.impl;

import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import leibniz.hu.oatest.dao.GenericDao;
import leibniz.hu.oatest.dao.JobDao;
import leibniz.hu.oatest.domain.Job;
import leibniz.hu.oatest.service.JobService;

@Service("jobService")
public class JobServiceImpl extends GenericServiceImpl<Job> implements JobService{
	
	@Resource(name="jobDao")
	public void initDao(GenericDao<Job> dao) {
        super.setDao(dao);
    }
	@Override
	public Set<Job> getJobsByIds(Long[] ids) {
		return ((JobDao)this.dao).getJobsByIds(ids);
	}
}
