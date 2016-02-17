package leibniz.hu.oatest.action;

import java.util.Collection;

import javax.annotation.Resource;

import leibniz.hu.oatest.domain.User;
import leibniz.hu.oatest.service.UserService;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

@Controller("userAction")
@Scope("prototype")
public class UserAction extends ActionUtil<User>implements ModelDriven<User>{
	private static final long serialVersionUID = 9213851736233247844L;
	@Resource(name="userService")
	private UserService userServ;
	
	//列出所有用户及对应的部门、岗位信息
	public String listAll(){
		Collection<User> userList = this.userServ.getAllUsers();
		ActionContext.getContext().getValueStack().push(userList);;
		return list;
	}
	
}
