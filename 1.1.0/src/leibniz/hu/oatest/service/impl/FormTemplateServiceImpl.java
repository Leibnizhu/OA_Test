package leibniz.hu.oatest.service.impl;

import java.io.File;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import leibniz.hu.oatest.dao.GenericDao;
import leibniz.hu.oatest.domain.FormTemplate;
import leibniz.hu.oatest.service.FormTemplateService;
import leibniz.hu.oatest.utils.UploadUtils;

@Service("formTemplateService")
public class FormTemplateServiceImpl extends GenericServiceImpl<FormTemplate> implements FormTemplateService{
	@Resource(name="formTemplateDao")
	private void initDao(GenericDao<FormTemplate> dao){
		super.setDao(dao);;
	}

	@Override
	public void saveFormTemplate(FormTemplate formTemplate, File resource) {
		String url = UploadUtils.saveUploadFile(resource);
		formTemplate.setUrl(url);
		this.saveElement(formTemplate);
	}
}
