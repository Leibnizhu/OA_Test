package leibniz.hu.oatest.dao.impl;

import org.springframework.stereotype.Repository;

import leibniz.hu.oatest.dao.FormTemplateDao;
import leibniz.hu.oatest.domain.FormTemplate;

@Repository("formTemplateDao")
public class FormTemplateDaoImpl extends GenericDaoImpl<FormTemplate> implements FormTemplateDao{

}
