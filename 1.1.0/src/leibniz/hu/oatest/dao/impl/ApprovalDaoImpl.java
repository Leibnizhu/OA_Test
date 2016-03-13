package leibniz.hu.oatest.dao.impl;

import org.springframework.stereotype.Repository;

import leibniz.hu.oatest.dao.ApprovalDao;
import leibniz.hu.oatest.domain.Approval;

@Repository("approvalDao")
public class ApprovalDaoImpl extends GenericDaoImpl<Approval> implements ApprovalDao{

}
