package leibniz.hu.oatest.service;

import java.io.File;

import org.springframework.transaction.annotation.Transactional;

import leibniz.hu.oatest.domain.FormTemplate;

public interface FormTemplateService extends GenericService<FormTemplate>{
	@Transactional(readOnly=false)
	public void saveFormTemplate(FormTemplate formTemplate, File resource);
}
