package leibniz.hu.oatest.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;

import javax.annotation.Resource;

import org.jbpm.api.ProcessDefinition;
import org.jbpm.api.ProcessDefinitionQuery;
import org.jbpm.api.ProcessEngine;
import org.springframework.stereotype.Service;

import leibniz.hu.oatest.service.ProcDefManager;

@Service("procDefManager")
public class ProcDefManagerImpl implements ProcDefManager {
	@Resource(name="processEngine")
	private ProcessEngine procEng; 
	
	@Override
	public Collection<ProcessDefinition> showLatestVersions() {
		//通过ProcessEngine创建六成定义查询，并按version字段升序排序，输出一个List，这个List每个流程定义出现最后一个都是最后版本
		List<ProcessDefinition> procDefList = this.procEng.getRepositoryService().createProcessDefinitionQuery().orderAsc(ProcessDefinitionQuery.PROPERTY_VERSION).list(); 
		//创建一个Map，以流程定义key键，以流程定义为值
		Map<String, ProcessDefinition> procDefMap = new HashMap<String, ProcessDefinition>();
		for(ProcessDefinition procDef : procDefList){
			//将流程定义依次存放进Map，后放进来的同key流程定义为更新版本，这样最后出来的Map就是包含了最新流程定义版本
			procDefMap.put(procDef.getKey(), procDef);
		}
		return procDefMap.values();
	}

	@Override
	public InputStream showProcDefImg(String deploymentId) {
		ProcessDefinition procDef = this.procEng.getRepositoryService().createProcessDefinitionQuery().deploymentId(deploymentId).uniqueResult();
		return this.procEng.getRepositoryService().getResourceAsStream(deploymentId, procDef.getImageResourceName());
	}

	@Override
	public void deleteByPDKey(String pDKey) {
		//先得到这个key对应的所有流程定义
		Collection<ProcessDefinition> procDefList = this.procEng.getRepositoryService().createProcessDefinitionQuery().processDefinitionKey(pDKey).list();
		for(ProcessDefinition pd : procDefList){
			//级联删除相关的流程实例和历史
			this.procEng.getRepositoryService().deleteDeploymentCascade(pd.getDeploymentId());
		}
	}

	@Override
	public void deploy(File uploadZipFile) {
		try {
			ZipInputStream zis = new ZipInputStream(new FileInputStream(uploadZipFile));
			this.procEng.getRepositoryService().createDeployment().addResourcesFromZipInputStream(zis).deploy();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
