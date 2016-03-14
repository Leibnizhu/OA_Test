package leibniz.hu.oatest.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.opensymphony.xwork2.ActionContext;

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

	@Override
	public InputStream download(Long ftid) {
		InputStream is = null;
		try {
			FormTemplate formTemplate = this.getElementById(ftid);
			//因为不经过struts标签，所以要手动手动编码
			ActionContext.getContext().put("fileName", URLEncoder.encode(formTemplate.getFtname(), "utf-8"));
			is = new FileInputStream(new File(formTemplate.getUrl()));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return is;
	}
}
