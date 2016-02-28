package leibniz.hu.oatest.action;

import com.opensymphony.xwork2.ActionSupport;

public class forwardAction extends ActionSupport{

	private static final long serialVersionUID = -1038040429427078787L;

	public String top(){
		return "top";
	}
	
	public String right(){
		return "right";
	}
	
	public String left(){
		return "left";
	}
	
	public String bottom(){
		return "bottom";
	}
	
	public String kynamic(){
		return "kynamic";
	}
}
