package leibniz.hu.oatest.action;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import leibniz.hu.oatest.domain.Kynamic;
import leibniz.hu.oatest.domain.Version;
import leibniz.hu.oatest.service.KynamicService;

@Controller("kynamicAction")
@Scope("prototype")
public class KynamicAction extends ActionUtil<Kynamic>{
	private static final long serialVersionUID = 8739356501260021553L;

	@Resource(name="kynamicService")
	private KynamicService kynamicServ;
	
	private Collection<Kynamic> menuList;
	public Collection<Kynamic> getMenuList() {
		return menuList;
	}
	
	private Collection<Version> versionList ;
	public Collection<Version> getVersionList() {
		return versionList;
	}

	//用于返回查询重名的结果
	private String returnMsg;
	public String getReturnMsg() {
		return returnMsg;
	}
	
	//用于返回添加之后的kid
	private Long kid; 	
	public Long getKid() {
		return kid;
	}

	public String showTree(){
		this.menuList = this.kynamicServ.getAllElements();
		return SUCCESS;
	}
	
	//根据节点名字判断时否已经存在
	public String isNameExists(){
		if(this.kynamicServ.isNameExists(this.getModel().getKname())){
			//存在重名
			this.returnMsg = "0";
		} else {
			this.returnMsg = "1";
		}
		return SUCCESS;
	}
	
	public String addKynamic(){
		this.kynamicServ.saveElement(this.getModel());
		this.kid = this.getModel().getKid();
		this.returnMsg = "操作成功";
		return SUCCESS;
	}
	
	public String deleteKynamic(){
		this.kynamicServ.deleteElement(this.kynamicServ.getElementById(this.getModel().getKid()));
		this.returnMsg = "操作成功";
		return SUCCESS;
	}
	
	public String updateKynamic(){
		//因为是只更新名字，其他不变，所以先查询出来再修改
		Kynamic kynamic = this.kynamicServ.getElementById(this.getModel().getKid());
		kynamic.setKname(this.getModel().getKname());
		this.kynamicServ.updateElement(kynamic);
		return SUCCESS;
	}
	
	public String getVersionsByKid(){
		this.versionList = this.kynamicServ.getVersionsByKid(this.getModel().getKid());
		return SUCCESS;
	}
}
