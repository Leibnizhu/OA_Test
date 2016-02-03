package leibniz.hu.oatest.action;

import com.opensymphony.xwork2.ActionSupport;

public class ActionUtil extends ActionSupport{
	private static final long serialVersionUID = 1904920961907881187L;
	
	//定义一些常用的Action返回值字符串
	public static final String LIST = "list";
	public static final String ADD_WEB = "addWeb";
	public static final String UPDATE_WEB = "updateWeb";
	public static final String JUMP_ACTION = "jumpAction";
	
	public String list = LIST;
	public String addWeb = ADD_WEB;
	public String updateWeb = UPDATE_WEB;
	public String jumpAction = JUMP_ACTION;
}
