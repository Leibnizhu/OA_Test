package leibniz.hu.oatest.dao.impl;

import org.springframework.stereotype.Repository;

import leibniz.hu.oatest.dao.FormDao;
import leibniz.hu.oatest.domain.Form;

@Repository("formDao")
public class FormDaoImpl extends GenericDaoImpl<Form> implements FormDao{

}
