package leibniz.hu.oatest.service;

import java.io.File;
import java.io.InputStream;
import java.util.Collection;

import org.jbpm.api.ProcessDefinition;

public interface ProcDefManager {
	public Collection<ProcessDefinition> showLatestVersions();
	//根据deploymentId获取对应的流程图输入流
	public InputStream showProcDefImg(String deploymentId);
	//根据pdkey删除流程定义
	public void deleteByPDKey(String pDKey);
	//部署流程定义
	public void deploy(File uploadZipFile);
}
