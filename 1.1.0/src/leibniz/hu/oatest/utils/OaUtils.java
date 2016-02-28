package leibniz.hu.oatest.utils;

import org.apache.struts2.ServletActionContext;

import leibniz.hu.oatest.domain.User;

public class OaUtils {
	public static Long[] string2Longs(String str){
		String[] s = str.split(",");
		Long[] longs = new Long[s.length];
		int index = 0;
		for(String string:s){
			longs[index] = Long.valueOf(string);
			index++;
		}
		return longs;
	}

	public static void putUserToSession(User user) {
		ServletActionContext.getRequest().getSession().setAttribute("user", user);
	}
	
	public static User getUserFromSession(){
		return (User)ServletActionContext.getRequest().getSession().getAttribute("user");
	}
}
