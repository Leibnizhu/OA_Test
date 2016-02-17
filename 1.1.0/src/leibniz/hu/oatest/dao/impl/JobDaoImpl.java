package leibniz.hu.oatest.dao.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import leibniz.hu.oatest.dao.JobDao;
import leibniz.hu.oatest.domain.Job;

@Repository("jobDao")
public class JobDaoImpl extends GenericDaoImpl<Job> implements JobDao{
	public Set<Job> getJobsByIds(Long[] ids){
		//根据id数组拼接成SQL/HQL查询语句
		StringBuffer sbSql = new StringBuffer();
		sbSql.append("from Job where jid in (");
		for(int i = 0; i < ids.length; i++){
			sbSql.append(ids[i]);
			if(i != ids.length - 1){
				sbSql.append(",");
			}
		}
		sbSql.append(")");
		System.out.println(sbSql.toString());
		//通过HibernateTemplate查询
		@SuppressWarnings("unchecked")
		List<Job> jobList = this.getHibernateTemplate().find(sbSql.toString());
		//通过Map去掉重复项
		return new HashSet<Job>(jobList);
	}
}
