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
	/*@Resource(name="jobDao")
	private JobDao jobDao;*/
	@Resource(name="jobDao")
	public void initDao(GenericDao<Job> dao) {
        super.setDao(dao);
    }
	@Override
	public Set<Job> getJobsByIds(Long[] ids) {
		return ((JobDao)this.dao).getJobsByIds(ids);
	}
	/*@Override
	public void saveElement(Job element) {
		this.jobDao.saveElement(element);
	}
	@Override
	public void deleteElement(Job element) {
		this.jobDao.deleteElement(element);
	}
	@Override
	public void updateElement(Job element) {
		this.jobDao.updateElement(element);
	}
	@Override
	public Job getElementById(Serializable id) {
		return this.jobDao.getElementById(id);
	}
	@Override
	public Collection<Job> getAllElements() {
		return this.jobDao.getAllElements();
	}*/
}
