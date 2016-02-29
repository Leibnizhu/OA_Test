package leibniz.hu.oatest.action;

import java.util.Date;

import javax.annotation.Resource;

import leibniz.hu.oatest.domain.Version;
import leibniz.hu.oatest.service.KynamicService;
import leibniz.hu.oatest.service.VersionService;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("versionAction")
@Scope("prototype")
public class VersionAction extends ActionUtil<Version>{
	private static final long serialVersionUID = -2099925615819635718L;
	
	@Resource(name="versionService")
	private VersionService versionServ;
	
	@Resource(name="kynamicService")
	private KynamicService kynamicServ;

	//用于返回查询重名的结果
	private String returnMsg;
	public String getReturnMsg() {
		return returnMsg;
	}
	
	private Long kid;
	public Long getKid() {
		return kid;
	}
	public void setKid(Long kid) {
		this.kid = kid;
	}

	public String delVersionByVid(){
		this.versionServ.deleteElement(this.versionServ.getElementById(this.getModel().getVid()));
		this.returnMsg = "操作成功";
		return SUCCESS;
	}
	
	public String addVersion(){
		this.getModel().setUpdatetime(new Date());
		this.getModel().setKynamic(this.kynamicServ.getElementById(this.kid));
		this.getModel().setVersion(this.versionServ.getMaxVersionByKid(this.kid) + 1);
		this.versionServ.saveElement(this.getModel());
		this.returnMsg = "操作成功";
		return SUCCESS;
	}
}
